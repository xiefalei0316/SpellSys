package com.feri.ts.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @program: TalentShow
 * @description:
 * @author: Feri
 * @create: 2019-09-11 16:29
 */
public class JedisTest {
    @Test
    public void t1(){
        //1、创建连接对象 客户端对象
        Jedis jedis=new Jedis("123.56.27.199",6379);
        //2、设置密码
        jedis.auth("666888");
        //3、操作Redis  命令--->方法名
        //操作 String   常规字符串
//        jedis.set("str","我是谁");
//        //操作 List  保证添加顺序 可重复
//        jedis.lpush("list","abc");
//        //操作 Set  不保证添加顺序 不可重复
//        jedis.sadd("set","记得投票");
//        // 操作Zset 不保证添加顺序 不可重复，但是多个权重（分数，double 可以重复）
//        jedis.zadd("zaet",2.3,"我与众不同");
//        // 操作 Hash  可以存储键值对 键唯一 值可以重复
//        jedis.hset("hash","id","123");

        jedis.setex("小时", 10, "马上就消失");

        //4、关闭
        jedis.close();;


    }
}
