package com.allaihoop.allaihoop_imagehandler.controller;

import com.allaihoop.allaihoop_imagehandler.MQConfig;
import com.allaihoop.allaihoop_imagehandler.service.ImageDeleterService;
import com.allaihoop.allaihoop_imagehandler.service.ImageSaverService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MessageListener {

    @Autowired
    ImageDeleterService deleterService;

    @Autowired
    ImageSaverService savingService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void deleteImageListener(String message) {
        deleterService.DeleteImage(message);
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void saveImageListener(ImageDTO imageDTO) {
        savingService.saveImage(imageDTO);
    }
}
