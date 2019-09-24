package seckill.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author Lei
 * @Date 2019-9-21 11:47
 */

@RabbitListener(queues = "directQueueOrder")
@Component
public class GoodListener {

    @RabbitHandler
    public void  getSeckilGood(String msg){

        System.out.println(msg+"订单操作");
        //订单操作

    }



}
