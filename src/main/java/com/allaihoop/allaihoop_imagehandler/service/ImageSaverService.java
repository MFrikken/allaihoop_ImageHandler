package com.allaihoop.allaihoop_imagehandler.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ImageSaverService implements S3Service{

    @Autowired
    AmazonS3 amazonS3;

    @Value("${clous.aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public void uploadImage(String key, InputStream inputStream, ObjectMetadata metadata) {
        amazonS3.putObject(bucketName, key, inputStream, metadata);
    }

    public void saveImage(ImageDTO imageDTO) {
        Imagemodel image = imageDTO.toModel();
        uploadImage();
    }
}
