package seckill.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Lei
 * @Date 2019-9-21 10:29
 */

@Configuration
public class DirectConfig {

    @Bean
    public Queue directQueue1(){

        return new Queue("directQueueOrder",true);//durable 设施队列持久化
    }

    @Bean
    public Queue directQueue2(){
        return  new Queue("directQueueDecr",true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange",true,false);
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("order");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("decr");
    }





}
