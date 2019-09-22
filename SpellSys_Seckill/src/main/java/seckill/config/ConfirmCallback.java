package seckill.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author Lei
 * @Date 2019-9-22 10:04
 */

@Component
public class ConfirmCallback  implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("消息唯一标识"+correlationData);

        System.out.println("确认结果"+b);

        System.out.println("失败原因"+s);

    }
}
