package com.inditex.demo.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InditexDateTimeFormatter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public static LocalDateTime toLocalDateTime(String date) {
        return LocalDateTime.parse(date, formatter);
    }
}
