package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.exception.DateFormatException;

import static org.apache.http.util.Asserts.notNull;

// Domain primitive for date in ISO-format
// YY-MM-DDTHHMMSSZ
public class Date {
    private final String year;
    private final String month;
    private final String day;
    private final String hour;
    private final String minute;
    private final String second;

    public Date(String file_fieldname) throws DateFormatException {
        notNull(file_fieldname, "Field name must not be empty.");
        if(!(file_fieldname.length() == 16)) throw new DateFormatException("Provided date does not fit ISO-Format length.");

        String[] dateComponents = file_fieldname.split("-");
        for (int i = 0; i <= 1; i++) {
            isNumerical(dateComponents[i]);
        }
        if (dateComponents.length == 3) {
            String[] timeComponents = dateComponents[2].split("[TZ]");
        }

    }
}
