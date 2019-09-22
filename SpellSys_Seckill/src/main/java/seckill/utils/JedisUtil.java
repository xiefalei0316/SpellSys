package seckill.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class JedisUtil {

    //private static Log logger = LogFactory.getLog(JedisUtils.class);

    /**
     * 自动注入Redis连接实例对象线程池
     */
    @Autowired(required = false)
    private JedisPool jedisPool;

    private JedisUtil() {
        if (jedisPool == null) {
            String ip = "39.105.189.141";
            int port = 6379;
            String password ="qfjava";
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(1000);
            jedisPoolConfig.setMaxIdle(4000);
            jedisPoolConfig.setMaxWaitMillis(10000);
            if (password != null && !"".equals(password)) {
                // redis 设置了密码
                jedisPool = new JedisPool(jedisPoolConfig, ip, port, 10000, password);
            } else {
                // redis 未设置密码
                jedisPool = new JedisPool(jedisPoolConfig, ip, port, 10000);
            }
        }
    }

    /**
     * 获取Jedis对象
     * @return
     */
    public synchronized Jedis getJedis(){
        Jedis jedis = null;
        if(jedisPool != null){
            try{
                if(jedis == null ){
                    jedis = jedisPool.getResource();
                }
            }catch(Exception e){
               // logger.error(e.getMessage(),e);
                e.printStackTrace();
            }
        }
        return jedis;
    }


    /**
     * 回收Jedis对象资源
     * @param jedis
     */
    public synchronized  void returnResource(Jedis  jedis){
        if(jedis != null){
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * Jedis对象出异常的时候，回收Jedis对象资源
     * @param jedis
     */
    public synchronized  void returnBrokenResource(Jedis  jedis){
        if(jedis != null){
            jedisPool.returnBrokenResource(jedis);
        }

    }
}