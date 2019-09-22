package com.qfedu.api;

import com.qfedu.api.service.WorkOrderServerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description TODO
 * @Name WorkOrderConsumerApplication
 * @Author Yama
 * @Date 2019/9/20 11:28
 * @Version V1.0
 */
@SpringBootApplication // 开关类
@EnableDiscoveryClient // 发现服务
@EnableFeignClients // 启用 Feign 实现服务消费
@EnableSwagger2 // swagger 在线文档
public class WorkOrderConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkOrderConsumerApplication.class, args);
    }
}
