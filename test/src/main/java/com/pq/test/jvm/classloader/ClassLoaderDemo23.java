package com.pq.test.jvm.classloader;

import sun.misc.Launcher;

import java.util.Arrays;

/**
 * 在运行期，一个java类是由该类的完全限定名(binary name,二进制名)和用于加载该类的定义类加载器(defining loader)所共同决定的。如果同样名字(即相同的完全限定名)的类是由两个不同的加载器所加载，那么这些类就是不同的，即使.class文件的字节码完全一样，并且从相同的位置加载亦如此
 *
 * 在Oracle的Hotspot中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下错误信息：
 * Error occurred during initialization of VM
 *  java/lang/NoClassDefFoundError: java/lang/Object
 *
 */
public class ClassLoaderDemo23 {
    public static void main(String[] args) {
        // 跟加载器加载路径
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        // 扩展类加载器加载路径
//        System.out.println(System.getProperty("java.ext.dirs"));
//        // 系统加载器加载路径
//        System.out.println(System.getProperty("java.class.path"));

        /**
         * 内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类，
         * 当JVM启动时，一块特殊的机器码会运行，他会加载扩展类加载器和系统类加载器，
         * 这块特殊的机器码加启动类加载器(Bootstrap)
         *
         * 启动类加载器并不是java类，而其他的加载器则都是java类，
         * 启动类加载器是特定于平台的机器指令，她负责开启整个加载过程。
         *
         * 所有类加载器(除了启动类加载器)都被实现为java类。不过总归要有一个加载器来加载第一个java类加载器，从而让整个加载过程能够顺利进行下去，
         * 加载第一个纯Java类加载器的就是启动类加载的职责
         *
         * 启动类加载器还会负责加载供jre正常运行所需要的组件，这包括java.lang和java.util包中的类等等
         */

        System.out.println(ClassLoader.class.getClassLoader());

        // 扩展类加载器与系统类加载器也是有启动类加载器所加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("---------------");
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(ClassLoaderDemo23.class.getClassLoader());
        System.out.println(ClassLoaderDemo16.class.getClassLoader());
        // [null]是因为重写了toString()方法，返回的是定义的ClassLoaderName成员变量，而指定系统类加载器是调用传入ClassLoader的构造方法，所以打印的是[null]
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
