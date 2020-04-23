package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("-----------------");
        ClassLoaderDemo15[] classLoaderDemo15s = new ClassLoaderDemo15[2];
        System.out.println(classLoaderDemo15s.getClass().getClassLoader());
        System.out.println("-----------------");
        int[] ints = new int[2];
        // 原生(java的基本数据类型)的类型是没有类加载器的
        System.out.println(ints.getClass().getClassLoader());
    }
}
