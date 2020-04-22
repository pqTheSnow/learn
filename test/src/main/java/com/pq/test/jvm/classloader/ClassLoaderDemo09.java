package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo09 {
    static {
        System.out.println("ClassLoaderDemo09 out");
    }

    public static void main(String[] args) {
        // ClassLoaderDemo09的静态代码块会优先执行，也就是ClassLoaderDemo09会先初始化
        System.out.println(MyChild9.b);
    }
}


class MyParent9 {
    public static int a = 9;
    static {
        System.out.println("MyParent9 out");
    }
}

class MyChild9 extends MyParent9 {
    public static int b = 9;
    static {
        System.out.println("MyChild9 out");
    }
}