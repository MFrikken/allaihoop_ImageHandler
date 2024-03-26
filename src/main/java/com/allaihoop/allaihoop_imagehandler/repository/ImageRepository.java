package com.allaihoop.allaihoop_imagehandler.repository;

import org.springframework.stereotype.Repository;

import java.io.File;

import static org.apache.commons.lang3.Validate.notNull;


@Repository
public class ImageRepository {

    private final String shortTimeStorage = "/home/mfrikken/WebstormProjects/allaihoop_web/backend/data/shortTimeStorage/";
    public File fetchFileFromShortTimeStorage(String filename) {
        File file = new File(shortTimeStorage + filename);
        notNull(file);
        return file;
    }
}
