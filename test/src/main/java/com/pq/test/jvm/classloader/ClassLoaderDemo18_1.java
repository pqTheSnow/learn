package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderDemo16 loader1 = new ClassLoaderDemo16("loader1");
        loader1.setPath("");

        // 将 ClassLoaderDemo01.class 放到跟加载器的加载路径上，ClassLoaderDemo01.class将被根加载器加载，即ClassLoaderDemo01.getClassLoader()为null
        Class<?> clazz = loader1.loadClass("com.pq.test.jvm.classloader.ClassLoaderDemo01");

        System.out.println("class : " + clazz.hashCode());
        System.out.println("class loader : " + clazz.getClassLoader());
    }
}
