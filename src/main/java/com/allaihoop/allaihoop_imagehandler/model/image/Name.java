package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.model.image.date.Date;

import static org.apache.commons.lang3.Validate.notNull;

// name of every image comprises a filename, a date, and a file extension
public class Name {
    private final Fieldname fieldname;
    private final Date date;
    private final Extension extension;

    public Name(String filename) throws Exception {
        notNull(filename);
        String[] components = splitFilename(filename);

        this.fieldname = new Fieldname(components[0]);
        this.date = new Date(components[1]);
        this.extension = new Extension(components[2]);
    }

    private String[] splitFilename(String filenameString) {
        String filename = filenameString.split("[-.]", 2)[0];
        String dateAndExtension = filenameString.split("[-.]", 2)[1];

        String date = dateAndExtension.split("\\.")[0];
        String extension = dateAndExtension.split("\\.")[1];

        return new String[]{filename, date, extension};
    }

    @Override
    public String toString() {
        return this.fieldname.getFieldname() + "-" + this.date + "." + this.extension.getExtension();
    }
}
