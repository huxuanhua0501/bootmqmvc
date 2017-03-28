package net.bootmq.rabbitmq.consumer;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by win7 on 2017/3/23.
 */
@Component
public class ConsumerMq {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerMq.class);

    @RabbitListener(queues = "${rabbitmq.message}")
    public void  consumer(Message str){
        logger.info("message:"+str);
        try {
            System.err.println(new String(str.getBody(),"utf-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
