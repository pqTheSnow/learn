package com.pq.test.jvm.classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来
 */
public class ClassLoaderDemo01 {
    public static void main(String[] args) {
        // 对于静态字段来说，只有直接定义了该字段的类才会被初始化
//        System.out.println(MyChild1.str);
        // 当一个类在初始化时，要求其父类全部都已经初始化完毕了
        System.out.println(MyChild1.child);
    }
}

class MyParent1 {
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 out");
    }
}

class MyChild1 extends MyParent1 {

    public static String child = "hello child";

    static {
        System.out.println("MyChild1 out");
    }
}
