package seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Lei
 * @Date 2019-9-20 21:02
 */

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("seckill.dao")
@EnableScheduling  //检查数据库秒杀商品
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class,args);
    }
}
