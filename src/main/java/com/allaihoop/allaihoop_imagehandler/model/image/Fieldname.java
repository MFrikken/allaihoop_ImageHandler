package com.allaihoop.allaihoop_imagehandler.model.image;

import static com.allaihoop.allaihoop_imagehandler.model.image.Validator.isValid;
import static org.apache.commons.lang3.StringUtils.isAlphanumeric;
import static org.apache.commons.lang3.Validate.notNull;

// may contain any alphanumeric character but specials
public class Fieldname {
    private final String fieldname;

    public Fieldname(String fieldname) throws Exception {
        notNull(fieldname);
        isValid(isAlphanumeric(fieldname), "Fieldname must not contain special characters.");

        this.fieldname = fieldname;
    }

    public String getFieldname() {
        return fieldname;
    }
}
