package com.pq.test.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

public class ClassLoaderDemo14 {
    public static void main(String[] args) throws IOException {
        //
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com/pq/test/jvm/classloader/ClassLoaderDemo14.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("-------");
        // rt.jar由根类加载器加载
        Class<String> clazz = String.class;
        System.out.println(clazz.getClassLoader());
    }
}
