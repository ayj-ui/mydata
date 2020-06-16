package com.example.mydata.controller.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
/*@RabbitListener(queues = "test")*/
public class RabbitMqReceive {

    /*@RabbitHandler
    public void process(String message){
        System.out.println("收到message="+message);
    }*/

}
