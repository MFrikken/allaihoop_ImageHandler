package com.allaihoop.allaihoop_imagehandler.model.image;

import java.awt.*;

import static org.apache.commons.lang3.Validate.notNull;

public class ImageDTO {
    private Name filename;
    private Image imageFile;
    private Feedback feedback;

    public ImageDTO(Name filename, Image imageFile, Feedback feedback) {
        notNull(filename);
        notNull(imageFile);
        notNull(feedback);

        this.filename = filename;
        this.imageFile = imageFile;
        this.feedback = feedback;
    }

    public ImageModel toModel() throws Exception {
       return new ImageModel(this.filename.toString(), this.feedback.getFeedback());
    }
}
