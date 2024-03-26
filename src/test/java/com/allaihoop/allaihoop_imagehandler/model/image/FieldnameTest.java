package com.allaihoop.allaihoop_imagehandler.model.image;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldnameTest {

    @Nested
    @DisplayName("Tests for constructor")
    class ConstructorTests {

        @Test
        void shouldReturnValidFieldnameObject() throws Exception {
            // given
            String fieldnameString = "sdfg334hjkdf";

            // when
            // then
            assertDoesNotThrow(() -> new Fieldname(fieldnameString));
        }

        @Test
        void shouldThrowException() {
            // given
            String fieldnameString = null;

            // when
            RuntimeException result = assertThrows(RuntimeException.class, () -> {
                new Fieldname(fieldnameString);
            });
            String expected = "The validated object is null";

            // then
            assertEquals(expected, result.getMessage());
        }

        @Test
        void shouldThrowExceptionToo() {
            // given
            String fieldnameString = "hd/df-.23";

            // when
            Exception result = assertThrows(Exception.class, () -> {
                new Fieldname(fieldnameString);
            });
            String expected = "Fieldname must not contain special characters.";

            // then
            assertEquals(expected, result.getMessage());
        }
    }
}