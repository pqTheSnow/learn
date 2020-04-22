package com.pq.test.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化，只有真正的使用到了父接口的时候(如引用接口中所定义的常量时)，才会初始化
 *
 * 当java虚拟机初始化一个类时，要求它的所有父类都已经初始化，但是这条规则并不适用于接口
 * 1. 在初始化一个类时，并不会先初始化它所实现的接口
 * 2. 在初始化一个接口时，并不会先初始化它的父接口
 * 因此，一个父接口并不会因为它的子接口或者实现类的初始化而初始化，只有当程序首次使用特定接口的静态变量时，才会导致该接口的初始化
 */
public class ClassLoaderDemo05 {
    public static void main(String[] args) {
        // MyParent5_1.b只有在运行期才可以确定，因此需要对MyParent5_1做初始化，也就需要对他的父类MyParent5做初始化，所以如果删掉MyParent5.class，会报NoClassDefFoundError错误
//        System.out.println(MyChild5.b);
        // MyParent5_1.c在编译器就可以确定会被加到ClassLoaderDemo05的常量池中，因此不会初始化MyParent5_1，也就不会初始化他的父类MyParent5，所以如果删掉MyParent5.class，会报NoClassDefFoundError错误
//        System.out.println(MyChild5.c);
        // ***********************************
//        System.out.println(MyChild5_1.a);
//        System.out.println(MyChild5_1_1.a);
        System.out.println(MyParent5_1.a);
        // 不显示的调用MyParent5_1.thread，MyParent5_1.thread不会被初始化，即使显示的调用了MyParent5_1.a
        System.out.println(MyParent5_1.thread);
    }
}

// ############例1###############
interface MyParent5 {
    int a = 2;
}

interface MyChild5 extends MyParent5 {
    int b = new Random().nextInt(3);
    // c 默认为常量，
    int c = 3;
}

// ############例2###############
interface MyParent5_1 {
    Thread thread = new Thread(){
        {
            // 当thread初始化的时候，会执行该代码块
            System.out.println("MyParent5_1 invoke");
        }
    };
    int a = 1;

}

interface MyChild5_1 extends MyParent5_1 {
    int a = 3;
}

class MyChild5_1_1 implements MyParent5_1{
    // 在初始化一个类的时候，不会先初始化它所实现的接口，但是回加载，尝试删除MyParent5_1.class文件，运行程序会报错
    public static int a = 3;
}
