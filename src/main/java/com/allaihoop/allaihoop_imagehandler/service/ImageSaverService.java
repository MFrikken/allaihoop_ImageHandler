package com.allaihoop.allaihoop_imagehandler.service;

import com.allaihoop.allaihoop_imagehandler.model.image.Feedback;
import com.allaihoop.allaihoop_imagehandler.model.image.ImageModel;
import com.allaihoop.allaihoop_imagehandler.repository.ImageRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageSaverService implements S3Service {

    private final ImageRepository repository = new ImageRepository();

    @Autowired
    AmazonS3 amazonS3;

    @Value("${clous.aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public void uploadImage(String key, InputStream imagefile, ObjectMetadata metadata) throws IOException {
        amazonS3.putObject(bucketName, key, imagefile, metadata);
    }

    public void saveImage(String filename, boolean feedback) throws Exception {
        ImageModel image = new ImageModel(filename, feedback);
        try {
            File imagefile = repository.fetchFileFromShortTimeStorage(image.getName().toString());
            InputStream inputStream = new FileInputStream(imagefile);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.addUserMetadata(image.getName().toString(), String.valueOf(feedback));

            String key = "/allaihoop/images/" + image.getName().toString();
            uploadImage(key, inputStream, metadata);
        } catch (IOException e) {
            System.out.println("Failed to upload image: " + e.getMessage());
        }
    }
}
