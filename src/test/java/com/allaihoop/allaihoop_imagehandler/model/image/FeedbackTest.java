package com.allaihoop.allaihoop_imagehandler.model.image;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

    @Nested
    @DisplayName("Tests for 'toString()'")
    class TestsToString {

        @Test
        void shouldReturnTrue() {
            // given
            Feedback feedbackTrue = new Feedback(true);

            // when
            String result = feedbackTrue.toString();
            String expected = "true";

            // then
            assertEquals(expected, result);
        }

        @Test
        void shouldReturnFalse() {
            // given
            Feedback feedbackFalse = new Feedback(false);

            // when
            String result = feedbackFalse.toString();
            String expected = "false";

            // then
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Tests for 'toFileNameAppendix'")
    class ToFileNameAppendixTests {

        @Test
        void shouldReturn01() {
            // given
            Feedback feedbackTrue = new Feedback(true);

            // when
            String result = feedbackTrue.toFileNameAppendix();
            String expected = "01";

            // then
            assertEquals(expected, result);
        }

        @Test
        void shouldReturn00() {
            // given
            Feedback feedbackFalse = new Feedback(false);

            // when
            String result = feedbackFalse.toFileNameAppendix();
            String expected = "00";

            // then
            assertEquals(expected, result);
        }
    }

}