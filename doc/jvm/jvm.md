# JVM
- jvm参数
   - -XX:+optiong，表示开启option选项
   - -XX:-optiong，表示关闭option选项
   - -XX:optiong=value，表示将option选项的值设置为value
   - -XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xmx20m
      - 生成对快照
   - -XX:+TraceClassLoading
      - 用于追踪类的加载信息并打印出来

- 线程共享区
   - 方法区
   - java堆
- 线程独占区
   - 虚拟机栈
   - 本地方法栈
   - 程序计数器

## 类加载器
- 编译
   - 常量在编译阶段会存入到调用这个常量的方法所在的常量池中，本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量类的初始化
- 在java代码中，类型的加载、连接与初始化过程都是在程序运行期间完成的
   - 类的加载
      - 最常见的就是将磁盘上的class文件加载到内存中，将其放到运行时数据区的<font color = red>方法区</font>内，然后在内存中创建一个java.lang.CLass对象，用来封装类在方法区内的<font color=red>数据结构</font>
      - 查找并加载类的二进制数据
   - 连接
      - 验证：确保类被加载类的正确性
      - 准备：为类的<font color=red>静态变量</font>分配内存，并将其初始化为<font color=red>默认值</font>
      - 解析：<font color=red>把类中的符号引用转换为直接引用</font>
   - 初始化
      - 为类的静态变量赋予正确的初始值
   ```java
   class Test{
      // 在连接阶段会给a复制默认值0
      // 在初始化过程，会将1赋值给a
      // 也就是说a = 1是两个过程
      public staitc fianl a = 1;
   }
   ```
   - 类的使用
   - 类的卸载
      - 从内存中卸载
      - 如osgi

- 类的加载、连接与初始化过程中，java对类的使用方式(两种)
   - 主动使用(七种，需要从字节码的层面理解最好)
      - 创建类的实例
      - 访问某个类或接口的静态变量，或者对该静态变量赋值
      - 调用类的静态方法
      - 反射
      - 初始化一个类的子类(extend)
      - java虚拟机启动时被标明为启动类的类
      - jdk7开始提供的动态语言支持
   - 被动使用
      - 除了主动使用外的使用，都是被动使用，都不会导致类的初始化
- java助记符
   - getstatic
   - putstatic
   - invokestatic
   - ldc表示将int, float或是string类型的常量值从常量池中推送至栈顶
   - bipush表示将单字节(-128 - 127)的常量值推送至栈顶
   - sipush表示将一个短整型常量值(-32768 - 32767)推送至栈顶
   - iconst_1表示将int类型1推送至栈顶
   - ...
- 所有的java虚拟机实现必须在每个类或接口被java程序“首次主动使用”时才初始化他们

## java虚拟机与程序的生命周期
- java虚拟机结束生命周期
   - 程序中显示的调用的System.exit()
   - 程序正常执行结束
   - 程序执行过程中遇到错误，异常终止
   - 操作系统出错导致java虚拟机终止