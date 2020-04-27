package com.pq.test.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

import java.util.Arrays;

public class ClassLoaderDemo19 {
    public static void main(String[] args) {
        // AESKeyGenerator 在扩展类加载器的加载路径下，更改其加载路径，加导致该类ClassNotFoundError
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(ClassLoaderDemo19.class.getClassLoader());
    }
}
