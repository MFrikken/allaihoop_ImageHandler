package com.allaihoop.allaihoop_imagehandler.service;

import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.InputStream;

public interface S3Service {
    void uploadImage(String key, InputStream inputStream, ObjectMetadata metadata);
}
