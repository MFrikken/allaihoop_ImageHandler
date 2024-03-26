package com.allaihoop.allaihoop_imagehandler.model.image;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageDTOTest {

    @Nested
    @DisplayName("Tests for 'toModel()'")
    class ToModelTests {

        @Test
        void shouldReturnValidImageModel() throws Exception {
            // given
            Image imagefile = Mockito.mock(Image.class);
            Name name = new Name("dkfg98-2024-03-22T17-15-16462Z.png");
            Feedback feedback = new Feedback(true);
            ImageDTO dto = new ImageDTO(name, imagefile, feedback);

            // when
            ImageModel result = dto.toModel();
            ImageModel expected = new ImageModel("dkfg98-2024-03-22T17-15-16462Z.png", true);

            // then
            assertEquals(expected.getName().toString(), result.getName().toString());
            assertEquals(expected.getFeedback().toString(), result.getFeedback().toString());
        }

        @Test
        void shouldThrowException() throws Exception {
            // given
            Image imagefile = Mockito.mock(Image.class);
            Name name = new Name("dkfg98-2024-03-22T17-15-16462Z.png");
            Feedback feedback = new Feedback(true);

            // when
            Exception result1 = assertThrows(Exception.class, () -> {
                new ImageDTO(null, imagefile, feedback);
            });
            Exception result2 = assertThrows(Exception.class, () -> {
                new ImageDTO(name, null, feedback);
            });
            Exception result3 = assertThrows(Exception.class, () -> {
                new ImageDTO(name, imagefile, null);
            });
            String expected = "The validated object is null";

            // then
            assertEquals(expected, result1.getMessage());
            assertEquals(expected, result2.getMessage());
            assertEquals(expected, result3.getMessage());
        }
    }

}