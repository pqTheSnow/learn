package com.pq.util;

/**
 * 临时作为通用的数据类，后期使用 日志代替
 */
public class LogUtil {
    public static void info(String log) {
        System.out.println(log);
    }
    public static void error(String log) {
        System.out.println(log);
    }
    public static void error(String log, Exception e) {
        System.out.println(log + e.getMessage());
    }
}
