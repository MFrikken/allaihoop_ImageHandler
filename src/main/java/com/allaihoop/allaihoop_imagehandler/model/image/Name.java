package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.exception.DateFormatException;
import com.allaihoop.allaihoop_imagehandler.model.image.date.Date;

import static org.apache.commons.lang3.Validate.notNull;

// name of every image comprises a filename, a date, and a file extension
public class Name {
    private final Fieldname fieldname;
    private final Date date;
    private final Extension extension;

    public Name(String filename) throws Exception {
        notNull(filename);
        String[] components = filename.split("[-.]", 2);


        this.fieldname = new Fieldname(components[0]);
        this.date = new Date(components[1]);
        this.extension = new Extension(components[1]);
    }

    @Override
    public String toString() {
        return this.fieldname + "-" + this.date + "." + this.extension;
    }
}
