package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo18 {
    public static void main(String[] args) {
        // 跟加载器加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 扩展类加载器加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        // 系统加载器加载路径
        System.out.println(System.getProperty("java.calss.path"));
    }
}
