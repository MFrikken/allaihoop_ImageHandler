package com.allaihoop.allaihoop_imagehandler.service;

import java.io.File;

public class ImageDeleter implements Runnable{

    public static final String DIRECTORY = "/home/mfrikken/WebstormProjects/allaihoop_web/backend/data/shortTimeStorage/";
    String file;

    public ImageDeleter(String filename) {
        file = filename;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            deleteImage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteImage() {
        File file = new File(DIRECTORY + this.file);
        if (file.delete()) System.out.println(this.file + " deleted.");
        else System.out.println("Deletion of " + this.file + " failed.");
    }
}
