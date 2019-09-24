package com.hzw.sales;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: TalentShow
 * @description:
 * @author: Feri
 * @create: 2019-09-10 11:51
 */
@SpringBootApplication //开关类
@MapperScan("com.hzw.sales.dao") //扫描Mybatis的Dao层接口
@EnableDiscoveryClient //注册服务
@EnableScheduling //启用定时任务（任务调度框架）
public class ApplicantApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApplicantApplication.class,args);
    }
}
