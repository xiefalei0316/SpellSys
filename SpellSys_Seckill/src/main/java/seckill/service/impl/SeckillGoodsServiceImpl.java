package seckill.service.impl;

import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Seckill;
import com.qfedu.entity.entity.Goods;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import seckill.dao.GoodsDao;
import seckill.dao.SeckillDao;
import seckill.service.SeckillGoodsService;
import seckill.utils.JedisLock;
import seckill.utils.JedisUtil;
import seckill.utils.StrTimeSecond;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Lei
 * @Date 2019-9-20 20:25
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    //总商品

    @Autowired(required = false)
    private GoodsDao goodsDao;

    //秒杀关联总商品
    @Autowired(required = false)
    private SeckillDao seckillDao;

    @Autowired
    private JedisUtil jedisUtil;

    //计算时间字符转毫秒
    @Autowired(required = false)
    private StrTimeSecond strTime;

    static  int i;
    //判断该商品的秒杀是否开始
    @Override
    public R QuerySeckillTime(int id) {
        //JedisUtil jds = JedisUtil.getInstance();

        Jedis jds = jedisUtil.getJedis();
        try {

            //距离商品开始时间 距离商品的结束时间 状态 TTime+id
            if (jds.exists("TTime" + id)) {
                String status = jds.get("TTime" + id);

                if (status.equals("0")) {//活动未开始

                    return RUtil.setR(false, String.valueOf(jds.ttl("TTime" + id)));
                }

                if (status.equals("1")) { //活动进行中

                    //判断库存是否为0

                    String repertory = jds.get("repertory" + id);

                    if (repertory != null && Integer.parseInt(repertory) > 0) {//该商品数量大于0

                        System.out.println("当前查询商品是否可以秒杀次数"+(i++));
                        return RUtil.setR(true, String.valueOf(jds.ttl("TTime") + id));
                    }

                    RUtil.setR(true, "0");//商品售罄
                }

            } else {

                //判断缓存中该商品是否结束
                if (jds.exists("Stime" + id)) {//活动还未结束，但不代表已经开始

                    //开始判断时间差  是否已经开始秒杀

                    //获取缓存中该商品的信息   //开始时间 结束时间 时长

                    List<String> lrange = jds.lrange("Stime" + id, 0, -1);

                    //获取当前时间
                    String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                    //比较当前时间与活动开始时间 start<0未开始
                    int start = currentTime.compareTo(lrange.get(0));

                    if (start < 0) {//活动还没有开始 判断距离的时差
                        long StartTime = strTime.getSecond(currentTime, lrange.get(0));

                        jds.set("TTime" + id, "0");//0代表活动尚未开始
                        jds.expire("TTime" + id, (int) (StartTime));//活动开始 该key消失

                        //返回距离活动开始的时差秒数
                        return RUtil.setR(false, String.valueOf(StartTime));
                    } else {//活动开始 判断距离的结束时间

                        long endTime = strTime.getSecond(currentTime, lrange.get(1));

                        jds.set("TTime" + id, "1");//1 代表活动开始了
                        jds.expire("TTime" + id, (int) (endTime));//结束 key消失



                        return RUtil.setR(true, String.valueOf(endTime));
                    }
                }
            }

        }catch (Exception e){

            jedisUtil.returnBrokenResource(jds);
        }finally {
            jedisUtil.returnResource(jds);
        }


        return null;
    }

    //添加秒杀商品
    @Override
    public R setSeckillGood(int id, Date beginTime, Date endTime) {

        //判断该id 是否属于总商品
        Goods goods = goodsDao.selectById(id);

        if (goods == null) {//商品不合法

            return RUtil.setR(false, "商品id不存在");

        }

      /*  Seckill selectOne = seckillDao.selectOne(new QueryWrapper<Seckill>().eq("g_id", id));
        if(selectOne==null){
            return RUtil.setR(false,"秒杀商品已经存在");
        }*/
        Seckill seckill = new Seckill();

        seckill.setBeginTime(beginTime);

        seckill.setEndTime(endTime);

        seckill.setG_id(id);

        return RUtil.setR(seckillDao.insert(seckill) > 0, "新增秒杀商品成功");
    }

    @Autowired(required = false)
    private RabbitTemplate rabbitTemplate;

    @Autowired(required = false)
    private JedisLock jlock;


    //判断库存量
   static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

   //判断用户是否重复购买
   static ConcurrentHashMap<String,String > umap = new ConcurrentHashMap<>();

    //秒杀商品购买
    @Override
    public R getSeckillGood(int id, int uid) {

       // JedisUtil instance = JedisUtil.getInstance();
        Jedis instance = jedisUtil.getJedis();

        try {
            Thread.sleep((long) Math.random());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            String status = instance.get("TTime" + id);


            if (status.equals("0")) {
                return RUtil.setERROR("错误入口,活动暂未开始！");
            } else {


                //判断用户是否重复购买
                String s = umap.get("user" + uid+id);
                /*if(s!=null && s.equals("user" + uid+id)){
                    return  RUtil.setERROR("请勿重复购买!!!");
                }*/


                if (!map.isEmpty() && map.get("repertory" + id) <= 0) {

                    return RUtil.setERROR("该商品售罄！");

                } else {

                    if (jlock.lock("sid" + id)) {//加锁 做操作 单一线程

                        int count = Integer.parseInt(instance.get("repertory" + id));

                        if (count > 0) {//库存有货 可以告知用户订单成功 并库存-1
                            //库存预减
                            Long decr = instance.decr("repertory" + id);

                            map.put("repertory" + id, decr);


                                rabbitTemplate.convertAndSend("directExchange", "order", "uid-"+id);//订单操作

                                rabbitTemplate.convertAndSend("directExchange", "decr", "uid-"+id);//数据库自减


                            umap.put("user" + uid+id,"user" + uid+id);
                            jlock.unlock("sid"+id);//解锁

                            return RUtil.setOK("下单成功");

                        } else {

                            return RUtil.setOK("下单失败,库存已售罄");
                        }

                    }else {
                        return RUtil.setERROR("当前人数过多!");
                    }

                }

            }
        }catch (Exception e){
            jedisUtil.returnBrokenResource(instance);

        }finally {
            jedisUtil.returnResource(instance);
        }
        return null;
    }
}
