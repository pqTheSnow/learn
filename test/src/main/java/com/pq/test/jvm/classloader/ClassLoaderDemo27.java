package com.pq.test.jvm.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 */
public class ClassLoaderDemo27 {
    public static void main(String[] args) throws Exception {
        // 看源码
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://47.101.65.238:3306/xwiki", "root", "123456");
    }
}
