package com.pq.test.jvm.classloader;


import java.util.Arrays;

public class ClassLoaderDemo07 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.pq.test.jvm.classloader.MyParent7");
        System.out.println("args = " + clazz2.getClassLoader());
    }
}

class MyParent7 {

}
