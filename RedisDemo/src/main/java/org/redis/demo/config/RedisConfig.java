package org.redis.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 17:53
 */
@Configuration
public class RedisConfig {

    private String host;

    private Integer port;

    private String password;

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(@Autowired RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        template.setKeySerializer(redisSerializer);
        template.setHashKeySerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);
        template.setHashValueSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean(name = "redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPassword(password);
        configuration.setPort(port);
        return new LettuceConnectionFactory(configuration);
    }

    @PostConstruct
    public void init(){
        host = "cartoon-ali.com";
        port = 6379;
        password = "asd12345";
    }
}
