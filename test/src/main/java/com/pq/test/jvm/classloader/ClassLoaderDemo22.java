package com.pq.test.jvm.classloader;

import java.util.Arrays;

public class ClassLoaderDemo22 {

    static {
        System.out.println("ClassLoaderDemo22 out");
    }

    public static void main(String[] args) {
        /**
         * 扩展类加载器(ExtClassLoader)只能加载.jar结尾的文件
         *
         * 生成jar命令
         * jar cvf test.jar com/pq/test/jvm/classloader/ClassLoaderDemo01.class
         *
         * 命令运行class，并指定扩展类加载器的加载路径
         * java -Djava.ext.dirs=./ com.pq.test.jvm.classloader.ClassLoaderDemo22
         */
        System.out.println(ClassLoaderDemo22.class.getClassLoader());
        System.out.println(ClassLoaderDemo01.class.getClassLoader());
    }
}
