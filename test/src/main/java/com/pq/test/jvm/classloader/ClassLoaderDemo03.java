package com.pq.test.jvm.classloader;

import java.util.Arrays;
import java.util.UUID;

public class ClassLoaderDemo03 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    // 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
    // str的值，运行期间才会确定
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 out");
    }
}
