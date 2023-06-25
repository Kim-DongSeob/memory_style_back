package com.memorystyle.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Util {
    public static String genId() {
        return UUID.randomUUID().toString();
    }
    public static String genDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD");
        String formattingDate = dateFormat.format(date);
        return formattingDate;
    }
}
