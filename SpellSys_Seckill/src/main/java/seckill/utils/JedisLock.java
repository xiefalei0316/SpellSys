package seckill.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @Author Lei
 * @Date 2019-9-21 11:19
 */

@Component
public class JedisLock {//库存单一操作


   // private JedisUtil jds= JedisUtil.();

     @Autowired
    private JedisUtil jedisUtil;




    //加锁
    public boolean lock(String  sid){
        Jedis jds =null;
        try {

            jds=jedisUtil.getJedis();
           if(jds.setnx(sid, "")!=0){//key不存在

               return true;
           }
       }catch (Exception e){
            //超时自动解锁
            jds.expire(sid,3);
           jedisUtil.returnBrokenResource(jds);
       }finally {
            jds.expire(sid,3);
           jedisUtil.returnResource(jds);
       }
       return false;
    }

    //解锁
    public void unlock(String sid){
        Jedis jds = null;
        try {
        jds=jedisUtil.getJedis();
        if(jds.get(sid)!=null){
            jds.del(sid);
        }
    }catch (Exception e){
        jedisUtil.returnBrokenResource(jds);
    }finally {
        jedisUtil.returnResource(jds);
    }
    }
}
