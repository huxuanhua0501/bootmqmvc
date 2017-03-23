package net.bootmq.rabbitmq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by win7 on 2017/3/23.
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class ConsumerConfig {

    @Autowired
    Environment env;
        @Bean
    public DirectExchange getExchange(){
        return new DirectExchange(env.getProperty("rabbitmq.exchange"));
    }
    @Bean
    public Queue queue(){
        return  new Queue(env.getProperty("rabbitmq.message"),true);
    }
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
        connectionFactory.setPort(Integer.parseInt(env.getProperty("spring.rabbitmq.port")));
        connectionFactory.setUsername(env.getProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(env.getProperty("spring.rabbitmq.password"));
        return connectionFactory;
    }
}
