package com.pq.test.jvm.classloader;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassLoaderDemo20 {
    public static void main(String[] args) throws Exception {
        ClassLoaderDemo16 loader1 = new ClassLoaderDemo16("loader1");
        ClassLoaderDemo16 loader2 = new ClassLoaderDemo16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.pq.test.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader1.loadClass("com.pq.test.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        System.out.println(obj1 == obj2);

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(obj1, obj2);
    }
}
