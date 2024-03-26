package com.allaihoop.allaihoop_imagehandler.model.image;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Nested
    @DisplayName("Tests for 'isNumerical()'")
    class IsNumericalTests {

        @Test
        void shouldReturnValidNumber() {
            // given
            String number = "123";

            // when
            int result = Validator.isNumerical(number);
            int expected = 123;

            // then
            assertEquals(expected, result);
        }

        @Test
        void shouldThrowException() {
            // given
            String number = "12a";
            String nullNumber = null;

            // when
            NumberFormatException result1 = assertThrows(NumberFormatException.class, () -> {
                Validator.isNumerical(number);
            });
            Exception result2 = assertThrows(Exception.class, () -> {
                Validator.isNumerical(nullNumber);
            });

            String expected1 = number + " is no numerical value.";
            String expected2 = "The validated object is null";

            // then
            assertEquals(expected1, result1.getMessage());
            assertEquals(expected2, result2.getMessage());
        }

        @Nested
        @DisplayName("Tests for 'isValid()'")
        class IsValidTests {

            @Test
            void shouldReturnTrue() throws Exception {
                // given
                String message = "this should not be printed.";

                // when
                boolean result = Validator.isValid(returnTrue(), message);
                boolean expected = true;

                // then
                assertEquals(expected, result);
            }

            @Test
            void shouldThrowExceptionWithMessage() {
                // given
                String message = "This should be printed.";

                // when
                Exception result = assertThrows(Exception.class, () -> {
                    Validator.isValid(returnFalse(), message);
                });
                String expected = message;

                assertEquals(expected, result.getMessage());
            }

            private boolean returnTrue() {
                return true;
            }

            private boolean returnFalse() {
                return false;
            }
        }
    }
}