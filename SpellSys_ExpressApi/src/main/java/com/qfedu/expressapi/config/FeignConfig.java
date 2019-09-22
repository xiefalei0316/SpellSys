package com.qfedu.expressapi.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Name FeignConfig
 * @Author Yama
 * @Date 2019/9/10 17:58
 * @Version V1.0
 */
@Configuration
public class FeignConfig {
    private int connecttimeout = 10000; // 10 秒
    private int readtimeout = 10000; // 10 秒
    @Bean
    public Request.Options createOp() {
        return new Request.Options(connecttimeout, readtimeout);
    }
}
