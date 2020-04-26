package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo17 {
    public static void main(String[] args) throws Exception {
        ClassLoaderDemo16 classLoader01 = new ClassLoaderDemo16("loader1");
        Class<?> clazz = classLoader01.loadClass("com.pq.test.jvm.classloader.MySample");
        System.out.println("class : " + clazz.hashCode());

        // 如果注释掉该行，那么b并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat.class
//        clazz.newInstance();

    }
}
