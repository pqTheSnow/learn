1. 使用javap -verbose命令分析一个字节码文件时，将会分析该字节码文件的魔数、版本号、常量池、类信息、类的构造方法、类中的方法信息、类变量与成员变量等信息。
   - javap
   - javap -c
   - javap -verbose
2. 魔数：所有的.class字节码文件的前4个字节都是魔数，魔数值为固定值：0xCAFEBABE