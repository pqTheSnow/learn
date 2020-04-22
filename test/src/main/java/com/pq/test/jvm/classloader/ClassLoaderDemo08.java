package com.pq.test.jvm.classloader;


public class ClassLoaderDemo08 {
    public static void main(String[] args) {
        System.out.println(MyParent8.a);
    }
}


class MyParent8 {
    public static int a = 3;

    static {
        System.out.println("MyParent8 out");
    }
}