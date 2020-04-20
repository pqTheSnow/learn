package com.pq.test.jvm.classloader;

public class ClassLoaderDemo06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1 = " + singleton.counter1);
        System.out.println("counter2 = " + singleton.counter2);
    }
}

class Singleton {
    public static int counter1 = 2;

    /*
    当public static int counter2 = 0;在这个位置时，输出的结果为
    singleton.counter1 = 1
    singleton.counter2 = 1
    counter1 = 1
    counter2 = 1            ******************不同的位置，值不一样
     */


    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;// 准备阶段的重要意义，即在类的准备阶段已经赋值，此处初始化使用的是准备阶段赋予的值
        System.out.println("singleton.counter1 = " + counter1);
        System.out.println("singleton.counter2 = " + counter2);
    }

    /*
    当public static int counter2 = 0;在这个位置时，输出的结果为
    singleton.counter1 = 1
    singleton.counter2 = 1  ********************此处之所以为1，是因为，在Singleton(){}中的counter2的值为准备状态的值，也就是0
    counter1 = 1
    counter2 = 0            ********************此处之所以为0，是因为，在在初始化过程中，是按照从上到下初始化的，所以在输出 ‘singleton.counter2 = 1’
    之后，counter2会被初始化为0
     */
    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }

}
