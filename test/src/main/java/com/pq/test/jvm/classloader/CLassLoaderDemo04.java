package com.pq.test.jvm.classloader;


import java.util.Arrays;

/**
 * 对于数组来说，其类型是有JVM在运行期间动态生成的，表示为[Lcom.pq.xxx这种形式。动态生成的类型，其父类型是Object
 * 对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 *
 *
 * - anewarray创建一个引用类型(如类，接口，数组)的数组，并将其引用值压入栈顶
 * - multianewarray创建多为数组
 * - newarray表示创建一个指定的原始类型(如int，float等)的数组，并将其引用值压入栈顶
 */
public class CLassLoaderDemo04 {
    public static void main(String[] args) {
        // 素组的使用不属于类加载的主动使用，即属于被动使用，故不会初始化，最终的结果就是 MyParent4 的静态代码块不会运行
        MyParent4[] arrs01 = new MyParent4[1];
        System.out.println(arrs01.getClass());
        System.out.println(arrs01.getClass().getSuperclass());
        System.out.println(arrs01.getClass().getSuperclass().getSuperclass());

        System.out.println("=======");

        MyParent4[][] arrs02 = new MyParent4[1][1];
        System.out.println(arrs02.getClass());
        System.out.println(arrs02.getClass().getSuperclass());
        System.out.println(arrs02.getClass().getSuperclass().getSuperclass());

        System.out.println("=======");
        MyParent4[][][] arrs03 = new MyParent4[1][1][1];

        System.out.println("=======");
        boolean[] flag = new boolean[1];
        char[] c = new char[1];
        byte[] b = new byte[1];
        short[] s = new short[1];
        int[] i = new int[1];
        long[] l = new long[1];
        float[] f = new float[1];
        double[] d = new double[1];
        System.out.println(flag.getClass());
        System.out.println(c.getClass());
        System.out.println(b.getClass());
        System.out.println(s.getClass());
        System.out.println(i.getClass());
        System.out.println(l.getClass());
        System.out.println(f.getClass());
        System.out.println(d.getClass());
    }
}

class MyParent4 {
    static {
        System.out.println("Myparent4 out");
    }
}
