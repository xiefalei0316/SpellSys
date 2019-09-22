package seckill.ScheduledTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author Lei
 * @Date 2019-9-21 8:56
 */

@Component
public class Task {


    //每天23时 将秒杀商品活动时间 添加到缓存中
    @Scheduled(cron = "0 0 23 * * ? ")
    public void ToRedisSeckill() {



    }

}
