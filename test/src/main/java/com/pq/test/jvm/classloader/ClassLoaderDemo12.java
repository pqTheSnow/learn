package com.pq.test.jvm.classloader;

import java.util.Arrays;

/**
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对垒的主动使用，不会导致类的初始化
 */
public class ClassLoaderDemo12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // classLoader.loadClass只是加载类，但是不初始化类
        Class<?> clazz = classLoader.loadClass("com.pq.test.jvm.classloader.ClassLoaderDemo12");
        System.out.println(clazz);
        System.out.println("-----------------");
        // 通过反射‘主动使用’ClassLoaderDemo12，所以ClassLoaderDemo12会初始化
        clazz = Class.forName("com.pq.test.jvm.classloader.MyParent12");
        System.out.println(clazz);
    }
}

class MyParent12 {
    static {
        System.out.println("MyParent12 out");
    }
}
