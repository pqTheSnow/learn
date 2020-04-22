package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo11 {
    public static void main(String[] args) {
        // MyChild11.a调用了父类MyParent11的静态变量，不会导致MyChild11的初始化
        System.out.println(MyChild11.a);
        // MyChild11.doSomething()调用了父类MyParent11的静态方法，不会导致MyChild11的初始化
        MyChild11.doSomething();
    }
}

class MyParent11 {
    public static int a = 8;

    static {
        System.out.println("MyParent11 out");
    }

    public static void doSomething() {
        System.out.println("MyParent11 doSomeThing");
    }
}

class MyChild11 extends MyParent11 {
    public static int b = 6;

    static {
        System.out.println("MyChild11 out");
    }

}