package com.allaihoop.allaihoop_imagehandler.controller;

import com.allaihoop.allaihoop_imagehandler.MQConfig;
import com.allaihoop.allaihoop_imagehandler.service.ImageDeleterService;
import com.allaihoop.allaihoop_imagehandler.service.ImageSaverService;
import com.allaihoop.allaihoop_imagehandler.service.SaveImageMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    ImageDeleterService deleterService;

    @Autowired
    ImageSaverService savingService;

    @RabbitListener(queues = MQConfig.DELETE_IMAGE_QUEUE)
    public void deleteImageListener(String message) {
        deleterService.DeleteImage(message);
    }

    @RabbitListener(queues = MQConfig.SAVE_IMAGE_QUEUE)
    public void saveImageListener(SaveImageMessage message) throws Exception {
        savingService.saveImage(message.getFilename(), message.getFeedback());
    }
}
