package com.allaihoop.allaihoop_imagehandler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class MessageListener {

    @Autowired
    ImageDeleterService service;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void deleteImageListener(String message) {
        service.DeleteImage(message);
    }
}
