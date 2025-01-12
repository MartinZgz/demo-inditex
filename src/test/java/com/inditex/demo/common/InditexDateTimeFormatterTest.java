package com.inditex.demo.common;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InditexDateTimeFormatterTest {

    @Test
    public void testToLocalDateTime() {
        String dateStr = "2020-06-15-16.00.00";
        LocalDateTime expectedDateTime = LocalDateTime.of(2020, 6, 15, 16, 0, 0, 0);

        LocalDateTime actualDateTime = InditexDateTimeFormatter.toLocalDateTime(dateStr);

        assertEquals(expectedDateTime, actualDateTime);
    }

    @Test
    public void testToLocalDateTime_withInvalidFormat() {
        String invalidDateStr = "2020-06-15 16:00:00";

        assertThrows(java.time.format.DateTimeParseException.class, () -> {
            InditexDateTimeFormatter.toLocalDateTime(invalidDateStr);
        });
    }
}
