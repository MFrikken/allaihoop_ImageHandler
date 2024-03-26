package com.allaihoop.allaihoop_imagehandler.model.image;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageModelTest {

    @Nested
    @DisplayName("Tests for 'toImageDTO()'")
    class ToImageDTOTests {

        @Test
        void shouldReturnValidImageDTO() throws Exception {
            // given
            ImageModel model = new ImageModel("sfdog89-2024-03-22T17-10-26448Z.jpeg", true);
            Image imagefile = Mockito.mock(Image.class);

            // when then
            assertDoesNotThrow(() -> model.toImageDTO(imagefile));

        }
    }

}