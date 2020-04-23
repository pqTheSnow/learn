package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo13 {
    public static void main(String[] args) {
        // 拿到的是系统类加载器，系统类加载器的父加载器是扩展类加载器，扩展类加载器的父加载器是根加载器
        // 注：跟加载器答应不出来，为null，具体原因暂时没有查明
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (null != classLoader) {
            classLoader = classLoader.getParent();

            System.out.println("--------");

            System.out.println(classLoader);
        }


    }
}
