package com.allaihoop.allaihoop_imagehandler.model.image.date;

import com.allaihoop.allaihoop_imagehandler.exception.DateFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Nested
    @DisplayName("Test validation for 'year'")
    class YearValidationTests {

        @Test
        public void shouldReturnValidYear() throws DateFormatException {
            // given
            String year = "2024";

            // when
            String result = Date.initYear(year);
            String expected = year;

            // then
            assertEquals(result, expected);
        }

        @Test
        public void shouldThrowException() throws DateFormatException {
            // given
            String year = "2034";

            // when
            DateFormatException result = assertThrows(DateFormatException.class, () -> {
                Date.initYear(year);
            });
            String expectedMessage = "Year does not match the required format.";

            // then
            assertEquals(expectedMessage, result.getMessage());
        }
    }

    @Nested
    @DisplayName("Test validation for 'month'")
    class MonthValidationTests {

        @Test
        public void shouldReturnValidMonth() throws DateFormatException {
            // given
            String month1 = "09";
            String month2 = "12";
            String month3 = "01";

            // when
            String result1 = Date.initMonth(month1);
            String result2 = Date.initMonth(month2);
            String result3 = Date.initMonth(month3);

            String expected1 = month1;
            String expected2 = month2;
            String expected3 = month3;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @Test
        public void shouldThrowException() {
            // given
            String month1 = "13";
            String month2 = "0";
            String month3 = "4";
            String month4 = "Januar";

            // when
            DateFormatException result1 = assertThrows(DateFormatException.class, () -> {
                Date.initMonth(month1);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                Date.initMonth(month2);
            });
            DateFormatException result3 = assertThrows(DateFormatException.class, () -> {
                Date.initMonth(month3);
            });
            NumberFormatException result4 = assertThrows(NumberFormatException.class, () -> {
                Date.initMonth(month4);
            });

            String expectedMessage1 = "Month does not match the required format.";
            String expectedMessage2 = month4 + " is no numerical value.";

            // then
            assertEquals(expectedMessage1, result1.getMessage());
            assertEquals(expectedMessage1, result2.getMessage());
            assertEquals(expectedMessage1, result3.getMessage());
            assertEquals(expectedMessage2, result4.getMessage());
        }
    }

    @Nested
    @DisplayName("Test validation for 'day'")
    class DayValidationTest {

        @Test
        public void shouldReturnValidDay() throws DateFormatException {
            // given
            String day1 = "01";
            String day2 = "31";
            String day3 = "14";

            // given
            String result1 = Date.initDay(day1);
            String result2 = Date.initDay(day2);
            String result3 = Date.initDay(day3);

            String expected1 = day1;
            String expected2 = day2;
            String expected3 = day3;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @Test
        public void shouldThrowException() {
            // given
            String day1 = "0";
            String day2 = "1";
            String day3 = "32";
            String day4 = "Monday";

            // when
            DateFormatException result1 = assertThrows(DateFormatException.class, () -> {
                Date.initDay(day1);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                Date.initDay(day2);
            });
            DateFormatException result3 = assertThrows(DateFormatException.class, () -> {
                Date.initDay(day3);
            });
            NumberFormatException result4 = assertThrows(NumberFormatException.class, () -> {
                Date.initDay(day4);
            });

            String expectedMessage1 = "Day does not match the required format.";
            String expectedMessage2 = day4 + " is no numerical value.";

            // then
            assertEquals(expectedMessage1, result1.getMessage());
            assertEquals(expectedMessage1, result2.getMessage());
            assertEquals(expectedMessage1, result3.getMessage());
            assertEquals(expectedMessage2, result4.getMessage());
        }
    }

    @Nested
    @DisplayName("Test validation for 'hour'")
    class HourValidationTests {

        @Test
        public void shouldReturnValidHour() throws DateFormatException {
            // given
            String hour1 = "00";
            String hour2 = "01";
            String hour3 = "10";
            String hour4 = "24";

            // when
            String result1 = Date.initHour(hour1);
            String result2 = Date.initHour(hour2);
            String result3 = Date.initHour(hour3);
            String result4 = Date.initHour(hour4);

            String expected1 = hour1;
            String expected2 = hour2;
            String expected3 = hour3;
            String expected4 = hour4;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
            assertEquals(expected4, result4);
        }

        @Test
        public void shouldThrowException() {
            // given
            String hour1 = "0";
            String hour2 = "1";
            String hour3 = "25";
            String hour4 = "five";

            // when
            DateFormatException result1 = assertThrows(DateFormatException.class, () -> {
                Date.initHour(hour1);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                Date.initHour(hour2);
            });
            DateFormatException result3 = assertThrows(DateFormatException.class, () -> {
                Date.initHour(hour3);
            });
            NumberFormatException result4 = assertThrows(NumberFormatException.class, () -> {
                Date.initHour(hour4);
            });

            String expectedMessage1 = "Hour does not match the required format.";
            String expectedMessage2 = hour4 + " is no numerical value.";

            // then
            assertEquals(expectedMessage1, result1.getMessage());
            assertEquals(expectedMessage1, result2.getMessage());
            assertEquals(expectedMessage1, result3.getMessage());
            assertEquals(expectedMessage2, result4.getMessage());
        }
    }

    @Nested
    @DisplayName("Test validation for 'minute'")
    class MinuteValidationTests {

        @Test
        public void shouldReturnValidMinute() throws DateFormatException {
            // given
            String minute1 = "00";
            String minute2 = "01";
            String minute3 = "59";

            // when
            String result1 = Date.initMinute(minute1);
            String result2 = Date.initMinute(minute2);
            String result3 = Date.initMinute(minute3);

            String expected1 = minute1;
            String expected2 = minute2;
            String expected3 = minute3;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @Test
        public void shouldThrowException() {
            // given
            String minute1 = "0";
            String minute2 = "60";
            String minute3 = "thirteen";

            // when
            DateFormatException result1 = assertThrows(DateFormatException.class, () -> {
                Date.initMinute(minute1);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                Date.initMinute(minute2);
            });
            NumberFormatException result3 = assertThrows(NumberFormatException.class, () -> {
                Date.initMinute(minute3);
            });

            String expectedMessage1 = "Minute does not match the required format.";
            String expectedMessage2 = minute3 + " is no numerical value.";

            // then
            assertEquals(result1.getMessage(), expectedMessage1);
            assertEquals(result2.getMessage(), expectedMessage1);
            assertEquals(result3.getMessage(), expectedMessage2);
        }
    }

    @Nested
    @DisplayName("Test validation for 'second'")
    class SecondValidationTests {

        @Test
        public void shouldReturnValidSecond() throws DateFormatException {
            // given
            String second1 = "00001";
            String second2 = "59000";
            String second3 = "00000";

            // when
            String result1 = Date.initSecond(second1);
            String result2 = Date.initSecond(second2);
            String result3 = Date.initSecond(second3);

            String expected1 = second1;
            String expected2 = second2;
            String expected3 = second3;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @Test
        public void shouldThrowException() {
            // given
            String second1 = "1";
            String second2 = "600000";
            String second3 = "twentytwo";

            // when
            DateFormatException result1 = assertThrows(DateFormatException.class, () -> {
                Date.initSecond(second1);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                Date.initSecond(second2);
            });
            NumberFormatException result3 = assertThrows(NumberFormatException.class, () -> {
                Date.initSecond(second3);
            });

            String expectedMessage1 = "Minute does not match the required format.";
            String expectedMessage2 = second3 + " is no numerical value.";

            // then
            assertEquals(expectedMessage1, result1.getMessage());
            assertEquals(expectedMessage1, result2.getMessage());
            assertEquals(expectedMessage2, result3.getMessage());
        }
    }

    @Nested
    @DisplayName("Test for constructor")
    class ConstructorTests {

        @Test
        public void shouldReturnValidDate() throws DateFormatException {
            // given
            String year = "2024";
            String month = "03";
            String day = "08";
            String hour = "15";
            String minute = "00";
            String second = "30457";
            String given_file_date = year + "-" + month + "-" + day + "T" + hour + "-" + minute + "-" + second + "Z";
            System.out.println(given_file_date);

            // when
            Date result = new Date(given_file_date);
            String expected = given_file_date;

            // then
            assertEquals(expected, result.toString());
        }

        @Test
        public void shouldThrowException() {
            // given
            String null_file_date = null;
            String short_file_date= "24-03-08T25-07-30457Z";

            // when
            IllegalStateException result1 = assertThrows(IllegalStateException.class, () -> {
                new Date(null_file_date);
            });
            DateFormatException result2 = assertThrows(DateFormatException.class, () -> {
                new Date(short_file_date);
            });

            String expectedMessage1 = "Field name must not be empty. is null";
            String expectedMessage2 = "Provided date does not fit ISO-Format length.";

            // then
            assertEquals(expectedMessage1, result1.getMessage());
            assertEquals(expectedMessage2, result2.getMessage());
        }
    }
}