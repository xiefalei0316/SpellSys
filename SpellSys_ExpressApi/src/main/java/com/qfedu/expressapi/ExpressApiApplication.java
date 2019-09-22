package com.qfedu.expressapi;

import com.qfedu.expressapi.service.ExpressApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description TODO
 * @Name ExpressApiApplication
 * @Author Yama
 * @Date 2019/9/21 20:12
 * @Version V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 发现服务
@EnableFeignClients // 启用 Feign 实现服务消费
@EnableSwagger2 // swagger 在线文档
public class ExpressApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpressApiApplication.class, args);
    }
}
