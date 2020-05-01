package com.pq.test.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 类加载器的双亲委托模型的好处
 * 1. 可以确保Java核心库的类型安全：所有的Java应用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个类会被加载到Java虚拟机中；如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的java.lang.Object类，而且这些类之间还是不兼容的，相互不可见的(正是命名空间在起作用)。
 * 借助于双亲委托机制，Java核心类库中的类加载工作都是由启动类加载器来统一完成的，从而确保了Java应用所使用的都是同一个版本的Java核心类库，他们之间是相互兼容的
 * 2. 可以确保Java核心类库所提供的类不会被自己定义的类所替代
 * 3. 不同的类加载器可以为相同的名称(binary name)的类创建额外的名命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的类加载器来加载他们即可。不同的类加载器所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个又一个相互隔离的java类空间，，这类技术在很多框架中都得到了实际应用
 */
public class ClassLoaderDemo21 {
    public static void main(String[] args) throws Exception {
        ClassLoaderDemo16 loader1 = new ClassLoaderDemo16("loader1");
        ClassLoaderDemo16 loader2 = new ClassLoaderDemo16("loader2");

        // ClassLoaderDemo21和ClassLoaderDemo20不同的地方此处设置了path
        loader1.setPath("F:\\tmp\\code\\");
        loader2.setPath("F:\\tmp\\code\\");

        Class<?> clazz1 = loader1.loadClass("com.pq.test.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader1.loadClass("com.pq.test.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        System.out.println(obj1 == obj2);

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        // 运行程序时删除MyPerson.class，将MyPerson.class移到loader1.path所指定的路径中，此处将在运行时出错，因为clazz1和clazz2通过反射生成的对象处在不同的命名空间中，即使他们的包名一样
        // 错误为： ClassCastException: com.pq.test.jvm.classloader.MyPerson can not cast to com.pq.test.jvm.classloader.MyPerson
        // 两个类虽然包名一样，但是命名空间不一样，所以相互不可见
        method.invoke(obj1, obj2);
    }
}
