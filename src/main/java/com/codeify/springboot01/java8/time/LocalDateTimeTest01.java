package com.codeify.springboot01.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author codeify
 * @since 2022/11/02 00:16
 */
public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date from = Date.from(localDateTime.toInstant(ZoneOffset.UTC).minus(8, ChronoUnit.HOURS));
//        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("from = " + from);
    }
}
