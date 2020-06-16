package com.example.mydata.controller.rabbitmq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitMq")
@Api(value = "测试rabbitmq",description = "测试tabbitMq")
public class TestController {

   @Autowired
    RabbitTemplate rabbitTemplate;

    @ApiOperation("发送rabbitmq")
    @RequestMapping(value = "/sand",method = RequestMethod.GET)
    public String sand(){
        rabbitTemplate.convertAndSend("exchange.direct","a","hello");
        return "success";
    }
}
