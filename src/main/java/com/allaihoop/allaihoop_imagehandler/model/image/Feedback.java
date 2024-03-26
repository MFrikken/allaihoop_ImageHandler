package com.allaihoop.allaihoop_imagehandler.model.image;

// feedback for an image classification is either true or false
// for long time saving, the value of feedback is appended to the image filename as numerical representation respectively
public class Feedback {
    private final boolean feedback;

    public Feedback(boolean feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return this.feedback ? "true" : "false";
    }

    public String toFileNameAppendix() {
        return feedback ? "01" : "00";
    }

    public boolean getFeedback() {
        return this.feedback;
    }
}
