package com.allaihoop.allaihoop_imagehandler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ImageDeleterService {

    @Async
    public void DeleteImage(String filename) {
        System.out.println("Deleting image: " + filename + " in 5 minutes.");
        ImageDeleter deleter = new ImageDeleter(filename);
        deleter.run();
    }
}
