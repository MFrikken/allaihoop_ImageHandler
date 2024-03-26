package com.allaihoop.allaihoop_imagehandler.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws.s3.buckets")
public class S3Buckets {

    private String allaihoop;

    public String getAllaihoop() {
        return allaihoop;
    }

    public void setAllaihoop(String allaihoop) {
        this.allaihoop = allaihoop;
    }
}
