package com.qfedu.checkin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.checkin.dao.CheckinDao;
import com.qfedu.checkin.dao.WalletDao;
import com.qfedu.checkin.service.CheckinService;
import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Checkin;
import com.qfedu.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckServiceImpl extends ServiceImpl<CheckinDao, Checkin> implements CheckinService {

    @Autowired(required = false)
    private CheckinDao checkinDao;

    @Autowired(required = false)
    private WalletDao walletDao;

    //插入签到记录
    @Override
    public R insertCheck(int uId) {

        int i = 0;
        //查询用户签到记录
        Checkin ck = checkinDao.selectById(uId);
        //1.如果记录为空说明第一次签到，第一次签到奖5元（金币）
        if (ck == null) {
            //插入签到记录
            i = insertCheckIn(uId, 5.00, 1);
            //更新用户资产
            updateWallet(uId, 5.00);
        } else {
            //3.每累计签到3天奖励0.5元（金币）
            if (ck.getCountDay() % 3 == 0) {
                i = insertCheckIn(uId, 0.5, ck.getCountDay() + 1);
                //更新用户资产
                updateWallet(uId, 0.5);
            } else {
                //2.不是第一次签到，每次奖励0.1元（金币）
                i = insertCheckIn(uId, 0.1, ck.getCountDay() + 1);
                //更新用户资产
                updateWallet(uId, 0.1);
            }
        }

        if (i > 0) {
            return RUtil.setOK("签到成功", ck);
        } else {
            return RUtil.setERROR("网络异常，未能成功");
        }

    }

    /**
     * 实现插入用户签到记录
     *
     * @param uId      一个Integer类型的参数，表示用户id
     * @param reward   一个Double类型的参数，表示奖励多少的金币
     * @param countDay 一个Integer类型的参数，表示连续签到天数
     * @return 返回一个int类型，表示受影响的行数
     */

    public int insertCheckIn(Integer uId, Double reward, int countDay) {

        //获取用户资产
        Wallet wallet = walletDao.selectById(uId);
        //创建空的签到对象
        Checkin ck = new Checkin();
        //为对象赋值
        ck.setuId(uId);
        ck.setCheckDate(new Date());
        ck.setBaseGold(wallet.getGold());
        ck.setCountDay(countDay);
        ck.setReward(reward);

        //获取插入受影响的行数
        int i = checkinDao.insert(ck);

        return i;
    }

    public int updateWallet(Integer uId, Double gold) {
        //获取用户资产
        Wallet wallet = walletDao.selectById(uId);

        wallet.setGold(wallet.getGold() + gold);

        int i = walletDao.updateById(wallet);

        return i;

    }
}
