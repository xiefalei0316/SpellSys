package com.qfedu.checkin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.checkin.dao.CheckinDao;
import com.qfedu.checkin.dao.WalletDao;
import com.qfedu.checkin.service.CheckinService;
import com.qfedu.common.util.DateUtil;
import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Checkin;
import com.qfedu.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CheckServiceImpl extends ServiceImpl<CheckinDao, Checkin> implements CheckinService {

    @Autowired(required = false)
    private CheckinDao checkinDao;

    @Autowired(required = false)
    private WalletDao walletDao;


    //插入签到记录
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public R insertCheck(int uId) {

        //结果变量
        Integer i = null;
        //奖励金额变量
        Double j = 0.00;
        //获取当前和昨天系统时间并转换格式

        //查询用户所有签到记录
        List<Checkin> checkins = checkinDao.findByUId(uId);

        //1.如果记录为空说明第一次签到，第一次签到奖5元（金币）
        if (checkins.size() == 0) {
            //插入签到记录
            i = insertCheckIn(uId, 5.00, 1);
            j = 5.00;
            //更新用户资产
            if (i != -1) {
                //如果签到无异常，更新用户资产
                updateWallet(uId, 5.00);
            }
        } else {
            //查询最近一条签到记录
            Checkin checkin = checkins.get(0);
            //判断是否重复签到
//            Date checkDate = checkin.getCheckDate();
//            String s = DateUtil.dateStr(checkin.getCheckDate(), 0);
//            Date date = new Date();
//            String s1 = DateUtil.dateStr(date, 0);

            if (DateUtil.dateStr(checkin.getCheckDate(), 0).equals(DateUtil.dateStr(new Date(), 0))) {
                i = 0;
            } else {
                if (DateUtil.dateStr(checkin.getCheckDate(), 0).equals(DateUtil.dateStr(new Date(), -1))) {
                    //3.每累计签到3天奖励0.5元（金币）
                    if (checkin.getCountDay() % 3 == 2) {
                        i = insertCheckIn(uId, 0.5, checkin.getCountDay() + 1);
                        j = 0.5;
                        //更新用户资产
                        updateWallet(uId, 0.5);
                    } else {
                        //2.是正常的连续签到，每次奖励0.1元（金币）
                        i = insertCheckIn(uId, 0.1, checkin.getCountDay() + 1);
                        j = 0.1;
                        //更新用户资产
                        updateWallet(uId, 0.1);
                    }
                } else {
                    //4.非连续签到，每次奖励0.1元（金币）
                    i = insertCheckIn(uId, 0.1, 1);
                    j = 0.1;
                    //更新用户资产
                    updateWallet(uId, 0.1);
                }
            }
        }

        if (i > 0) {
            return RUtil.setOK("签到成功", j);
        } else if (i == 0) {
            return RUtil.setERROR("每天只能签到一次");
        } else if (i == -1) {
            return RUtil.setERROR("请先为用户建立资产档案");
        } else {
            return RUtil.setERROR("网络异常，未能成功");
        }

    }

    /**
     * 查询昨天的签到记录
     *
     * @param uId 用户id
     * @return 返回签到记录对象
     */
    @Override
    public Checkin findCheckDateByUId(int uId) {
        return checkinDao.findCheckDateByUId(uId);
    }

    /**
     * 查询用户的签到记录，并根据签到时间进行降序排序
     *
     * @param uId 用户id
     * @return 返回
     */
    @Override
    public List<Checkin> findByUId(int uId) {
        return checkinDao.findByUId(uId);
    }

    /**
     * 实现插入用户签到记录
     *
     * @param uId      一个Integer类型的参数，表示用户id
     * @param reward   一个Double类型的参数，表示奖励多少的金币
     * @param countDay 一个Integer类型的参数，表示连续签到天数
     * @return 返回一个int类型，表示受影响的行数
     */

    @Transactional(propagation = Propagation.REQUIRED)
    public int insertCheckIn(Integer uId, Double reward, int countDay) {
        int i = 0;
        //获取用户资产
        Wallet wallet = walletDao.selectById(uId);
        //判断用户资产信息（档案）是否存在
        if (wallet == null) {
            //异常标识，表示没有为用户新建资产信息
            return i = -1;
        } else {
            //创建空的签到对象
            Checkin ck = new Checkin();
            //为对象赋值
            ck.setuId(uId);
            ck.setCheckDate(new Date());
            ck.setBaseGold(wallet.getGold());
            ck.setCountDay(countDay);
            ck.setReward(reward);

            //获取插入受影响的行数
            i = checkinDao.insert(ck);

            return i;
        }
    }

    /**
     * 跟新用户资产
     *
     * @param uId  用户id
     * @param gold 用户签到领取的金币
     * @return 返回受影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateWallet(Integer uId, Double gold) {
        //获取用户资产
        Wallet wallet = walletDao.selectById(uId);

        wallet.setGold(wallet.getGold() + gold);

        int i = walletDao.updateById(wallet);

//        int e=10/0;
        return i;
    }


}
