package com.allaihoop.allaihoop_imagehandler.model.image.date;

import com.allaihoop.allaihoop_imagehandler.exception.DateFormatException;

import static com.allaihoop.allaihoop_imagehandler.model.image.Validator.isNumerical;
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

    public Date(String file_date) throws DateFormatException {
        notNull(file_date, "Field name must not be empty.");
        if (!(file_date.length() == 16))
            throw new DateFormatException("Provided date does not fit ISO-Format length.");

        String[] dateComponents = file_date.split("-");
        // split string of time-component into each individual part
        if (dateComponents.length == 3) {
            String timeString = dateComponents[2].replaceAll("[TZ]", "");
            String[] timeComponents = new String[4];

            int i = 0;
            int j = 0;

            while (i <= timeComponents.length - 1) {
                while (j <= timeString.length() - 1) {
                    timeComponents[i] += timeString.charAt(j);
                    if (j % 2 == 0) i++;
                    j++;
                }
            }
        }

        this.year = initYear(dateComponents);
        this.month = initMonth(dateComponents);
        this.day = initDay(dateComponents);
        this.hour = initHour(dateComponents);
        this.minute = initMinute(dateComponents);
        this.second = initSecond(dateComponents);
    }

    private String initYear(String[] dateComponents) throws DateFormatException {
        if (isNumerical(dateComponents[0]) >= 0 && isNumerical(dateComponents[0]) <= 99) {
            return dateComponents[0];
        }
        throw new DateFormatException("Year does not match the required format.");
    }

    private String initMonth(String[] dateComponents) throws DateFormatException {
        if (isNumerical(dateComponents[1]) >= 1 && isNumerical(dateComponents[1]) <= 12) {
            return dateComponents[1];
        }
        throw new DateFormatException("Month does not match the required format.");
    }

    private String initDay(String[] timeComponents) throws DateFormatException {
        if (isNumerical(timeComponents[0]) >= 1 && isNumerical(timeComponents[0]) <= 31) {
            return timeComponents[0];
        }
        throw new DateFormatException("Day does not match the required format.");
    }

    private String initHour(String[] timeComponents) throws DateFormatException {
        if (isNumerical(timeComponents[1]) >= 0 && isNumerical(timeComponents[1]) <= 24) {
            return timeComponents[1];
        }
        throw new DateFormatException("Hour does not match the required format.");
    }

    private String initMinute(String[] timeComponents) throws DateFormatException {
        if (isNumerical(timeComponents[2]) >= 0 && isNumerical(timeComponents[2]) <= 59) {
            return timeComponents[2];
        }
        throw new DateFormatException("Minute does not match the required format.");
    }

    private String initSecond(String[] timeComponents) throws DateFormatException {
        if (isNumerical(timeComponents[3]) >= 0 && isNumerical(timeComponents[3]) <= 59) {
            return timeComponents[3];
        }
        throw new DateFormatException("Minute does not match the required format.");
    }

    @Override
    public String toString() {
        return this.year + "-" + this.month + "-" + this.day + "T" + this.hour + this.minute + this.second + "Z";
    }
}

