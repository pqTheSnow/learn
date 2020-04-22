package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo10 {
    static {
        System.out.println("ClassLoaderDemo10 out");
    }

    public static void main(String[] args) {
        MyParent10 myParent10;
        System.out.println("--------------");
        myParent10 = new MyParent10();
        System.out.println("--------------");
        System.out.println(myParent10.a);
        System.out.println("--------------");
        System.out.println(MyChild10.b);
    }
}

class MyParent10 {
    public static int a = 2;

    static {
        System.out.println("MyParent10 out");
    }
}

class MyChild10 extends MyParent10 {
    public static int b = 3;

    static {
        System.out.println("MyChild10 out");
    }
}