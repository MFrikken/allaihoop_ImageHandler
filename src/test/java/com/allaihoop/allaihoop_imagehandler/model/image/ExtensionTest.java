package com.allaihoop.allaihoop_imagehandler.model.image;

import com.allaihoop.allaihoop_imagehandler.exception.WrongExtensionError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionTest {

    @Nested
    @DisplayName("Tests for initExtension-function")
    class InitExtensionTests {

        @Test
        void shouldreturnValidExtension() {
            // given
            String extensionString1 = "jpeg";
            String extensionString2 = "jpg";
            String extensionString3 = "png";

            // when
            String result1 = Extension.initExtension(extensionString1);
            String result2 = Extension.initExtension(extensionString2);
            String result3 = Extension.initExtension(extensionString3);

            String expected1 = extensionString1;
            String expected2 = extensionString2;
            String expected3 = extensionString3;

            // then
            assertEquals(expected1, result1);
            assertEquals(expected2, result2);
            assertEquals(expected3, result3);
        }

        @Test
        void shouldThrowWrongExtensionError() {
            // given
            String wrongExtension = "wav";
            String nullExtension = null;

            // when
            WrongExtensionError result1 = assertThrows(WrongExtensionError.class, () -> {
                Extension.initExtension(wrongExtension);
            });
            WrongExtensionError result2 = assertThrows(WrongExtensionError.class, () -> {
                Extension.initExtension(nullExtension);
            });

            String exptected1 = "The given extension (" + wrongExtension + ") is not supported.";
            String exptected2 = "The given extension (" + nullExtension + ") is not supported.";

            // then
            assertEquals(exptected1, result1.getMessage());
            assertEquals(exptected2, result2.getMessage());
        }
    }

}