package com.qfedu.workorderserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description TODO
 * @Name WorkOrderServerApplication
 * @Author Yama
 * @Date 2019/9/20 10:43
 * @Version V1.0
 */

@SpringBootApplication
@MapperScan("com.qfedu.workorderserver")
@EnableDiscoveryClient // 注册服务
public class WorkOrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkOrderServerApplication.class, args);
    }
}
