package com.qfedu.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description TODO
 * @Name ExpressApplication
 * @Author Yama
 * @Date 2019/9/21 0:34
 * @Version V1.0
 */
@SpringBootApplication // 开关类
@MapperScan("com.qfedu.server.dao") // 扫描 dao 层注解
@EnableDiscoveryClient // 注册服务
public class ExpressApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }
}
