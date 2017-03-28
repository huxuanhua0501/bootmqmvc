package net.bootmq.rabbitmq.service.impl;

import com.alibaba.fastjson.JSON;
import net.bootmq.rabbitmq.pojo.BootTable;
import net.bootmq.rabbitmq.service.IRabbitmqService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by win7 on 2017/3/23.
 */
@Service
@PropertySource({"classpath:application.properties"})
public class RabbitmqService implements IRabbitmqService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RabbitmqService.class);
//    @Value("${rabbitmq.message}")
//    private  String queue;
//
//    @Value("${rabbitmq.key}")
//    private String queuekey;
//    @Value("${rabbitmq.exchange}")
//    private String exechange;

    @Autowired
    Environment env;


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void send(Object str) {
        BootTable bootTable = new BootTable();
        bootTable.setUsername("克鲁斯");
        bootTable.setPassword("123456");
        bootTable.setAge((short)22);
        bootTable.setSex((char)1);
        logger.info("sending message to rabbit = " + JSON.toJSONString(bootTable));
        rabbitTemplate.convertAndSend(env.getProperty("rabbitmq.exchange"),env.getProperty("rabbitmq.key"),  JSON.toJSONString(bootTable));

    }
}
