package com.allaihoop.allaihoop_imagehandler.service;

import static org.springframework.util.Assert.notNull;

public class SaveImageMessage {
    private String filename;
    private boolean feedback;

    public SaveImageMessage(String filename, boolean feedback) {
        notNull(filename, "filename must not be null.");

        this.filename = filename;
        this.feedback = feedback;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean getFeedback() {
        return this.feedback;
    }
}
