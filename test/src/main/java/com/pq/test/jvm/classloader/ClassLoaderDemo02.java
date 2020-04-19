package com.pq.test.jvm.classloader;

import java.util.Arrays;

/**
 * 助记符
 * - ldc表示将int, float或是string类型的常量值从常量池中推送至栈顶
 * - bipush表示将单字节(-128 - 127)的常量值推送至栈顶
 * - sipush表示将一个短整型常量值(-32768 - 32767)推送至栈顶
 * - iconst_1表示将int类型1推送至栈顶
 */
public class ClassLoaderDemo02 {
    public static void main(String[] args) {
        // 常量在编译阶段会存入到调用这个常量的方法所在的常量池中，本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量类的初始化
        // MyParent2.str是 static final的，是常量，这里的常量存放到了ClassLoaderDemo02的常量池中，之后MyParent2和ClassLoaderDemo02没有关系了，甚至将MyParent2.class文件删除，对结果没有影响
        System.out.println(MyParent2.str);
//        System.out.println(MyParent2.str2);
    }
}

class MyParent2 {
    public static final String str = "hello world";
    public static String str2 = "hello world2";
    static{
        System.out.println("MyParent2 out");
    }
}
