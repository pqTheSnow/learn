package com.pq.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class JVMDemo01 {

    public JVMDemo01() {
        byte[] array = new byte[128 * 1024];
    }

    public static void main(String[] args) {
        try {
//        jvisualvmTest();
            jconsoleTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void jvisualvmTest() {
        List<JVMDemo01> list = new ArrayList<>();
        while (true){
            list.add(new JVMDemo01());
        }
    }

    public static void jconsoleTest() throws InterruptedException {
        List<JVMDemo01> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            list.add(new JVMDemo01());
        }
    }

}
