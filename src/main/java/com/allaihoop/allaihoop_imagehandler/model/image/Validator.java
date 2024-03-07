package com.allaihoop.allaihoop_imagehandler.model.image;

import static org.apache.commons.lang3.Validate.notNull;

public abstract class Validator {
    public static int isNumerical(String number) {
        notNull(number);
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static boolean isValid(Boolean function, String message) throws Exception {
        if (function) return true;
        throw new Exception(message);
    }
}
