package com.pq.test.jvm.classloader;

import java.io.*;
import java.util.Arrays;

public class ClassLoaderDemo16 extends ClassLoader {
    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public ClassLoaderDemo16(ClassLoader classLoader) {
        super(classLoader);
    }

    public ClassLoaderDemo16(String classLoaderName) {
        super();// 将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public ClassLoaderDemo16(ClassLoader parent, String classLoaderName) {
        super(parent);// 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

//    @Override
//    public String toString() {
//        return "[" + this.classLoaderName + "]";
//    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("findClass invoked = " + className);
        System.out.println("class loader name = " + this.classLoaderName);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {

            name = name.replace(".", "\\");

            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
//        ClassLoaderDemo16 classLoaderDemo16 = new ClassLoaderDemo16("robot01");
//        classLoaderDemo16.setPath("F:\\tmp\\code\\");
//        test(classLoaderDemo16);
//        ClassLoaderDemo16 classLoaderDemo16_2 = new ClassLoaderDemo16("robot02");
//        classLoaderDemo16_2.setPath("F:\\tmp\\code\\");
//        test(classLoaderDemo16_2);
//        ClassLoaderDemo16 classLoaderDemo16_3 = new ClassLoaderDemo16("robot03");
//        classLoaderDemo16_3.setPath("F:\\tmp\\code\\");
//        test(classLoaderDemo16_3);

        // 卸载类
        unLoadClass();
    }

    public static void test(ClassLoader classLoader) throws Exception {
        // 直接修改类的包名，系统加载器加载的时候，会包ClassNotFoundError，所以在复制class文件做测试的时候，完整路径也要复制进去(com\pq\test\jvm\classloader)
        // 在服务启动的时候要删掉target/classes下的ClassLoaderDemo01.class，因为父加载器事可以加载到这个类的，这样我们自定义的加载器就不会区加载我们想他加载的class文件了(指定位置的)
        Class<?> clazz = classLoader.loadClass("com.pq.test.jvm.classloader.ClassLoaderDemo01");
        System.out.println("clazz : " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();
    }

    public static void unLoadClass() throws Exception {
        // 直接修改类的包名，系统加载器加载的时候，会包ClassNotFoundError，所以在复制class文件做测试的时候，完整路径也要复制进去(com\pq\test\jvm\classloader)
        // 在服务启动的时候要删掉target/classes下的ClassLoaderDemo01.class，因为父加载器事可以加载到这个类的，这样我们自定义的加载器就不会区加载我们想他加载的class文件了(指定位置的)
        ClassLoaderDemo16 classLoader = new ClassLoaderDemo16("robot01");
        classLoader.setPath("F:\\tmp\\code\\");
        Class<?> clazz = classLoader.loadClass("com.pq.test.jvm.classloader.ClassLoaderDemo01");
        System.out.println("clazz : " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();

        // 这段代码的目的就是卸载类，会输出如下结果
        // [Unloading class com.pq.test.jvm.classloader.ClassLoaderDemo01 0x1505a230]
        clazz = null;
        obj = null;
        classLoader = null;
        System.gc();

        classLoader = new ClassLoaderDemo16("robot02");
        classLoader.setPath("F:\\tmp\\code\\");
        clazz = classLoader.loadClass("com.pq.test.jvm.classloader.ClassLoaderDemo01");
        System.out.println("clazz : " + clazz.hashCode());
        obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();
    }
}
