package com.allaihoop.allaihoop_imagehandler.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Configuration {

    @Value("${aws.region}")
    private String bucketRegion;

    @Bean
    public S3Client s3Client() {
        S3Client client = S3Client.builder()
                .region(Region.of(bucketRegion))
                .build();
        return client;
    }
}
