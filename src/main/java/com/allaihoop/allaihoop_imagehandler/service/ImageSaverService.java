package com.allaihoop.allaihoop_imagehandler.service;

import com.allaihoop.allaihoop_imagehandler.model.image.ImageModel;
import com.allaihoop.allaihoop_imagehandler.repository.ImageRepository;
import com.allaihoop.allaihoop_imagehandler.repository.S3Buckets;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageSaverService {

    private final ImageRepository repository;
    private final S3Service s3Service;
    private final S3Buckets s3Buckets;

    public ImageSaverService(S3Service s3Service, ImageRepository repository, S3Buckets s3Buckets) {
        this.s3Service = s3Service;
        this.repository = repository;
        this.s3Buckets = s3Buckets;
    }

    public void saveImage(String filename, boolean feedback) throws Exception {
        ImageModel image = new ImageModel(filename, feedback);
        try {
            File imagefile = repository.fetchFileFromShortTimeStorage(image.getName().toString());
            byte[] imageBytes = FileUtils.readFileToByteArray(imagefile);
            String key = "allaihoop/images/" + image.getFeedback().toFileNameAppendix() + "/" + image.getName().toString();
            s3Service.putObject(s3Buckets.getAllaihoop(), key, imageBytes);

        } catch (IOException e) {
            System.out.println("Failed to upload image: " + e.getMessage());
        }
    }
}
