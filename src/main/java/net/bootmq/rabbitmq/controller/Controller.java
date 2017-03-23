package net.bootmq.rabbitmq.controller;

import net.bootmq.rabbitmq.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by win7 on 2017/3/22.
 */
@RestController
@RequestMapping("/boot")
public class Controller {
    @Autowired
    IRabbitmqService rabbitmqService;
    @GetMapping(value="rabbitmq")
    public void  rabbitmq(){
        rabbitmqService.send("你妹啊啊");
    }
}
