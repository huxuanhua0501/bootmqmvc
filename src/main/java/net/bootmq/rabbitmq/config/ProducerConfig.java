//package net.bootmq.rabbitmq.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//
///**
// * Created by win7 on 2017/3/22.
// */
//@Configuration
//@PropertySource({"classpath:application.properties"})
//public class ProducerConfig {
//    @Autowired
//    private Environment environment;
//    @Value("${rabbitmq.message}")
//    String queue;
//
//    @Value("${rabbitmq.key}")
//    String queuekey;
//    @Value("${rabbitmq.exchange}")
//    String exechange;
//
//    @Bean
//    public DirectExchange getExchange(){
//        return new DirectExchange(exechange);
//    }
//    @Bean
//    public Queue queue(){
//        return  new Queue(queue,true);
//    }
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(queue()).to(getExchange()).with(queuekey);
//    }
//    @Bean
//    public CachingConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(environment.getProperty("spring.rabbitmq.host"));
//        connectionFactory.setPort(Integer.parseInt(environment.getProperty("spring.rabbitmq.port")));
//        connectionFactory.setUsername(environment.getProperty("spring.rabbitmq.username"));
//        connectionFactory.setPassword(environment.getProperty("spring.rabbitmq.password"));
//        return  connectionFactory;
//    }
//
//}
