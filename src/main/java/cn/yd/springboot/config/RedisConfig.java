package cn.yd.springboot.config;

import cn.yd.springboot.po.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean("userRedisTemplate")
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        Jackson2JsonRedisSerializer<User> j = new Jackson2JsonRedisSerializer<User>(User.class);
        //value值的序列化采用fastJsonRedisSerializer
        // 序列化是为了使不同类型的数据方便传输，传输前进行序列化，接收到序列化数据后会还原成之前的数据类型
        template.setValueSerializer(j);
        template.setHashValueSerializer(j);
        //key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
        return template;//RedisTemplate就是操作Redis数据库的对象，并不是模板什么的，不要直译英文单词
    }
}
