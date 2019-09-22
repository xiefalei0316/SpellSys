package seckill.service;

import com.qfedu.common.vo.R;

import java.util.Date;

/**
 * @Author Lei
 * @Date 2019-9-20 20:22
 */

public interface SeckillGoodsService  {

    //判断商品是否开始秒杀

     R QuerySeckillTime(int id);


     //设置秒杀商品

     R setSeckillGood(int id, Date beginTime, Date endTime);


     R getSeckillGood(int id,int uid);



}
