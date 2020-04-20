package com.pq.test.jvm.classloader;


import java.util.Random;
import java.util.UUID;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化，只有真正的使用到了父接口的时候(如引用接口中所定义的常量时)，才会初始化
 */
public class ClassLoaderDemo05 {
    public static void main(String[] args) {
        // MyParent5_1.b只有在运行期才可以确定，因此需要对MyParent5_1做初始化，也就需要对他的父类MyParent5做初始化，所以如果删掉MyParent5.class，会报NoClassDefFoundError错误
        System.out.println(MyParent5_1.b);
        // MyParent5_1.c在编译器就可以确定会被加到ClassLoaderDemo05的常量池中，因此不会初始化MyParent5_1，也就不会初始化他的父类MyParent5，所以如果删掉MyParent5.class，会报NoClassDefFoundError错误
        System.out.println(MyParent5_1.c);
    }
}

interface MyParent5 {
    int a = 2;
}

interface MyParent5_1 extends MyParent5 {
    int b = new Random().nextInt(3);
    // c 默认为常量，
    int c = 3;
}
