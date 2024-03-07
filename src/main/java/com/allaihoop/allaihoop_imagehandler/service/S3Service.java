package com.allaihoop.allaihoop_imagehandler.service;

import com.allaihoop.allaihoop_imagehandler.model.image.Feedback;
import com.amazonaws.services.s3.model.ObjectMetadata;


import java.io.IOException;
import java.io.InputStream;

public interface S3Service {
    void uploadImage(String key, InputStream imagefile, ObjectMetadata metadata) throws IOException;
}
