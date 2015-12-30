package com.powertrader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

/**
 * Created by Luke on 29.12.2015.
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

    @Bean
    public HeaderHttpSessionStrategy sessionStrategy() {
        return  new HeaderHttpSessionStrategy();
    }


}
