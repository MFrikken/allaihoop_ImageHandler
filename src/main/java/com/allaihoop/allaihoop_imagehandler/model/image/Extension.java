package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.exception.WrongExtensionError;
import org.apache.commons.lang3.EnumUtils;

public class Extension {

    private final String extension;

    public Extension(String extension) {
        this.extension = initExtension(extension);
    }

    enum extensions {
        png,
        jpg,
        jpeg
    }

    private String initExtension(String extension) {
        if(EnumUtils.isValidEnum(extensions.class, extension)) {
            return extension;
        }
        throw new WrongExtensionError("The given extension (" + extension + " is not supported.");
    }
}
