# Java程序设计-实验报告-01

## 任务0：实验环境

- [x] 怎样将任务点标记为完成？
  - 回答：在条目开头的方括号填入`x`
- [x] 电脑品牌：Lenovo
- [x] 电脑型号：ThinkBook 14+
- [x] CPU型号：AMD R7-6800H
  - [x] CPU核心（core）数量：八核
  - [x] CPU默频/睿频：3.2/4.7 GHz
- [x] 内存规格：LPDDR5
- [x] 内存容量：512GB
- [x] 存储类型：SSD
- [x] 显卡型号：集成显卡
- [x] 屏幕分辨率：2880*1800
- [x] 最大功率：100W
- [x] 操作系统：Win11

## 任务1：HelloJava

- [x] 类名改成HelloJava2后还可以运行吗？为什么？

  不可以，与文件名不相同无法运行

- [x] Java程序的扩展名是什么？编译后的文件扩展名是什么？哪种是二进制文件？

  java程序扩展名为.java  

  编译后为.class 

  .class是二进制文件。

- [x] IDE是什么的缩写？和IDEA什么关系？再举几个Java IDE的例子。

  IntegratedDevelopmentEnvironment  集成开发环境

  IDEA是一种java开发的IDE

  Eclipse   BlueJ    jGRASP   JCreator ...

- [x] IDEA中源码出现红色波浪线、黄色波浪线分别是什么原因？

  红色：报错

  黄色：警告

- [x] 名词解释：
  - JDK：Java Development Kit  java开发工具包
  - JRE：Java Runtime Environment  java运行环境，是运行java程序所必需的环境的集合，包含JVM标准实现及Java核心类库
  - JVM：JavaVirtualMachine java虚拟机 用c++写的运行所有java程序的抽象计算机

## 任务2：调试示例（DebugDemo）

- [x] IDEA中以下功能的热键：
  - 构建项目：Ctrl+F9 
  - 运行程序：Shift+F10
  - 调试程序：Shift+F9
- [x] IDEA中以下调试功能的热键、用途：
  - Step Over (F8)：步过，一行一行地往下走，如果这一行上有方法不会进入方法
  - Step Into (F7)：步入，如果当前行有方法，可以进入方法内部，一般用于进入自定义方法内，不会进入官方类库的方法
  - Step Out (Shift + F8)：步出，从步入的方法内退出到方法调用处，此时方法已执行完毕，只是还没有完成赋值
  - Run to Cursor (Alt + F9)：运行到光标处，可以将光标定位到需要查看的那一行，然后使用这个功能，代码会运行至光标行，而不需要打断点
  - Resume Program (F9)：恢复程序，运行到下一个断点处，若无断点则运行完整个程序
  - Stop Program(Ctrl + F2)：停止程序
- [x] 断点（Breakpoints）的用途？IDEA下断点的热键（从Run菜单中找）
  - View Breakpoints (Ctrl + Shift + F8)：查看所有断点
  - Line breakpoint（Ctrl +F8）：行断点，在指定代码行设置断点，属于行级别的断点
  - Temporary line breakpoint：临时行断点，与行断点类似，不同之处在于该类型的断点在被激活之后会被立即删除
  - Method breakpoint（Ctrl+Alt+Shift+F8)：方法断点，它是标记在方法那一行的断点，有自己特有的属性参数

## 任务3：修正程序（Fixme）

- [x] 简要解释下列概念并各举一个例子（程序片段用反引号包围，例如`1+2`）。
  - 词法错误：
  
    - 用词错误
  
      `system`应为`System`
  
  - 语法错误：
  
    - 语法错误是对自然语言或编程语言的语法或语法规则的违反
  
      ` System.out.print('Hell')`应为`System.out.print("Hello");`
  
  - 语义错误：
  
    - 导致运行结果与预期结果不同
  
      `Hell`应为`Hello`
  
  - 逻辑错误：
  
    - 逻辑错误可能涉及更大的代码部分和代码的一般流程
  
      `System.in.print`应为`System.out.print`

## 任务4（选做）：命令行

- [x] 环境变量有什么用途？

  指定操作系统运行环境的一些参数

- [x] `PATH`环境变量的作用？

  指定命令搜索路径

- [x] JDK的`bin`目录中以下命令的用途？（本项可上网搜索，不查重）
  - `jar`：打包。
  - `java`：运行java程序
  - `javac`：编译的Java程序，生成.class文件
  - `jdb`：断点
  - `jps`：查看运行的JVM实例以及进程号
  - `jshell`：用于控制环境和显示信息
  - `jstack`：打印指定进程的调用堆栈信息
  - `jstat`：查看运行的JVM实例的运行数据

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。

- 熟悉Java开发环境的使用和配置。
- 熟悉IntelliJ IDEA软件的使用，包括创建项目、编辑程序、运行、调试等功能。

## 建议和意见（可选）
求早发模板 早早写完的人现在忙着往模板上誊
