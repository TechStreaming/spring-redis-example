package com.redis.example.springredisexample.config;

import com.redis.example.springredisexample.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
     JedisConnectionFactory  jedisConnectionFactory(){
        return  new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, User> redisTemplate(){
        RedisTemplate<String, User>  redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
