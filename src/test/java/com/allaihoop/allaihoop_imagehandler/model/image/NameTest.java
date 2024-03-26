package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.model.image.date.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Nested
    @DisplayName("Tests for constructor")
    class ConstructorTests {

        @Test
        void shouldConstructValidName() throws Exception {
            // given
            Fieldname givenFieldname = new Fieldname("sdlf345lkjn");
            Date givenDate = new Date("2024-03-22T13-30-23940Z");
            Extension givenExtension = new Extension("png");
            String givenFilename = givenFieldname.getFieldname() + "-" + givenDate + "." + givenExtension.getExtension();

            // when
            assertDoesNotThrow(() -> new Name(givenFilename));
            Name result = new Name(givenFilename);
            String expected = givenFilename;

            // then
            assertEquals(expected, result.toString());
        }

        @Test
        void shouldThrowException() {
            // given
            String nullFileName = null;

            // when
            Exception result = assertThrows(Exception.class, () -> {
                new Name(nullFileName);
            });
            String expected = "The validated object is null";


            // then
            assertEquals(expected, result.getMessage());
        }
    }

}