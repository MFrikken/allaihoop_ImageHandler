package com.allaihoop.allaihoop_imagehandler.model.image;

import java.awt.*;

public class ImageModel {
    private Name name;
    private Feedback feedback;

    public ImageModel(String filename, boolean feedback) throws Exception {
        this.name = new Name(filename);
        this.feedback = new Feedback(feedback);
    }

    public ImageDTO toImageDTO(Image imagefile) {
        return new ImageDTO(this.name, imagefile, this.feedback);
    }

    public Name getName() {
        return this.name;
    }

    public Feedback getFeedback() {
        return this.feedback;
    }
}
