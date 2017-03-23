package net.bootmq.rabbitmq.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.bootmq.rabbitmq.service.IRabbitmqService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sun.rmi.transport.ObjectTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win7 on 2017/3/23.
 */
@Service
public class RabbitmqService implements IRabbitmqService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RabbitmqService.class);
    @Value("${rabbitmq.message}")
    private  String queue;

    @Value("${rabbitmq.key}")
    private String queuekey;
    @Value("${rabbitmq.exchange}")
    private String exechange;


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void send(Object str) {
        logger.info("sending message to rabbit = " + str);
        Map<String,Object> map = new HashMap<>();
        map.put("got",str);
//        JSON.toJSONString(map);
        rabbitTemplate.convertAndSend(exechange,queuekey,  JSON.toJSONString(map));

    }
}
