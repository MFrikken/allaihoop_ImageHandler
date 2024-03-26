package com.allaihoop.allaihoop_imagehandler.model.image.date;

import com.allaihoop.allaihoop_imagehandler.exception.DateFormatException;

import static com.allaihoop.allaihoop_imagehandler.model.image.Validator.isNumerical;
import static org.apache.http.util.Asserts.notNull;

// Domain primitive for date in ISO-format
// YYYY-MM-DDTHH-MM-SSSSSZ
public class Date {
    private final String year;
    private final String month;
    private final String day;
    private final String hour;
    private final String minute;
    private final String second;

    public Date(String file_date) throws DateFormatException {
        notNull(file_date, "Field name must not be empty.");
        if (!(file_date.length() == 23))
            throw new DateFormatException("Provided date does not fit ISO-Format length.");

        String file_date_mod = file_date.replace("Z", "");
        String[] dateComponents = file_date_mod.split("[-T]");

        this.year = initYear(dateComponents[0]);
        this.month = initMonth(dateComponents[1]);
        this.day = initDay(dateComponents[2]);
        this.hour = initHour(dateComponents[3]);
        this.minute = initMinute(dateComponents[4]);
        this.second = initSecond(dateComponents[5]);
    }

    static String initYear(String year) throws DateFormatException {
        if (isNumerical(year) >= 2024 && isNumerical(year) <= 2024) {
            return year;
        }
        throw new DateFormatException("Year does not match the required format.");
    }

    static String initMonth(String month) throws DateFormatException {
        if ((isNumerical(month) >= 1 && isNumerical(month) <= 12) && month.length() == 2) {
            return month;
        }
        throw new DateFormatException("Month does not match the required format.");
    }

    static String initDay(String day) throws DateFormatException {
        if ((isNumerical(day) >= 1 && isNumerical(day) <= 31) && day.length() == 2) {
            return day;
        }
        throw new DateFormatException("Day does not match the required format.");
    }

    static String initHour(String hour) throws DateFormatException {
        if ((isNumerical(hour) >= 0 && isNumerical(hour) <= 24) && hour.length() == 2) {
            return hour;
        }
        throw new DateFormatException("Hour does not match the required format.");
    }

    static String initMinute(String minute) throws DateFormatException {
        if ((isNumerical(minute) >= 0 && isNumerical(minute) <= 59) && minute.length() == 2) {
            return minute;
        }
        throw new DateFormatException("Minute does not match the required format.");
    }

    static String initSecond(String second) throws DateFormatException {
        if ((isNumerical(second) >= 0 && isNumerical(second) <= 59000) && second.length() == 5) {
            return second;
        }
        throw new DateFormatException("Second does not match the required format.");
    }

    @Override
    public String toString() {
        return this.year + "-" + this.month + "-" + this.day + "T" + this.hour + "-" + this.minute + "-" + this.second + "Z";
    }
}

