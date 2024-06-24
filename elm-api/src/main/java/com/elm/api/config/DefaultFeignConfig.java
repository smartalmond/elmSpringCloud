package com.elm.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

// 设定OpenFeign输出日志
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
