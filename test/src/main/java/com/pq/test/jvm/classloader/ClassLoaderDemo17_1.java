package com.pq.test.jvm.classloader;

/**
 * 关于命名空间的重要说明
 * 1. 子加载器所加载的类能够访问到父加载器所加载的类
 * 2. 父加载器所加载的类无法访问到子加载器所加载的类
 */
public class ClassLoaderDemo17_1 {
    public static void main(String[] args) throws Exception {
        ClassLoaderDemo16 classLoader01 = new ClassLoaderDemo16("loader1");
        classLoader01.setPath("F:\\tmp\\code\\");

        Class<?> clazz = classLoader01.loadClass("com.pq.test.jvm.classloader.MySample");
        System.out.println("class : " + clazz.hashCode());

        // 如果注释掉该行，那么b并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat.class
        clazz.newInstance();

    }
}
