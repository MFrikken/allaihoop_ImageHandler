package com.allaihoop.allaihoop_imagehandler;

import java.io.File;

public class ImageDeleter implements Runnable{

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
        String directory = "/home/mfrikken/WebstormProjects/allaihoop/backend/data/shortTimeStorage/";
        File file = new File(directory + this.file);
        if (file.delete()) System.out.println(this.file + " deleted.");
        else System.out.println("Deletion of " + this.file + " failed.");
    }
}
