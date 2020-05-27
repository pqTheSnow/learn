package com.pq.test.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式 (获取 - 使用 - 还原)
 *
 * ClassLoader classLoader = Thread.currentThread.getContextClassLoader();
 * try {
 *      // 获取
 *     Thread.currentThread.setContextClassLoader(targetClassLoader);
 *     // 使用
 *     myMethod();
 * } finally {
 *      // 还原
 *      Thread.currentThread.setContextClassLoader(classLoader);
 * }
 *
 * myMethod里面调用了Thread.currentThread().getContextClassLoader(),获取当前上下文类加载器做某些事情。
 * 如果一个类由加载器A加载，那么这个类的依赖类也是有相同的类加载器加载的(如果该依赖类之前没有被加载的话)
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
 *
 * 当高层提供了统一的接口让底层去实现，同时要在高层加载(或实例化)底层的类时，就必须要通过线程上下文类加载器其来帮助高层的ClassLoader找到并加载该类
 *
 * 疑问：
 *    我们一般实现的类，都继承指Object，且是通过系统类加载器加载，那我们一般运行的程序又都是在主线程运行的，是否存在着除了 SPI 这种情况，
 *    我们一般也都用到了线程上线问加载类
 *
 *    基础类又要调用回用户的代码基础类又要调用回用户的代码 - 这是一个什么样的操作？
 *    Class.forName("com.mysql.jdbc.Driver");
 *
 *    以Connection来说，应该是java.sql.DriverManager.getConnection()内部调用了厂商的服务MysqlJDBC，但是DriverManager又属于跟类加载器，
 *    而MysqlJDBC属于系统加载器，所以就存在 ‘基础类又要调用回用户的代码基础类’ 的情况，也就是基础类已经实现了，但是可以用不同的服务提供商的实现替换掉，
 *    非 SPI 的实现，一般都是自己用代码实现的，不需要基础类回调，因此都可以被系统类加载器加载，故不存在问题
 *
 */
public class ClassLoaderDemo26 {
    public static void main(String[] args) {
        // 加上这一行，线程上下文类加载器就是ExtClassLoader，而这个类加载器加载不了classpath下的类，所以循环将不会输出任务东西
        Thread.currentThread().setContextClassLoader(ClassLoaderDemo26.class.getClassLoader().getParent());

        // ServiceLoader 加载的是 META-INF/services/com.example.CodecSet 这个路径下的全限定名的文件中的内容，然后实例化其中的类
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();

            System.out.println("driver = " + driver.getClass() + ", loader = " + driver.getClass().getClassLoader());
        }

        System.out.println("当前上下文类加载器 = " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader类加载器 = " + ServiceLoader.class.getClassLoader());
    }
}
