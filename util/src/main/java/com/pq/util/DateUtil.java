package com.pq.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate currentLocalDate() {
        return LocalDate.now();
    }

    public static LocalDateTime currentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 时间格式化
     * @param date
     * @param pattern 时间格式
     * @return
     */
    public static String dateFormat(Date date, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(dateToLocalDateTime(date));
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String currentTime() {
        return DATE_TIME_FORMATTER_1.format(currentLocalDateTime());
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String currentDate() {
        return DATE_TIME_FORMATTER_2.format(currentLocalDate());
    }

}
