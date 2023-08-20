# - Java程序设计-实验报告-02：方程求解

## 任务0：

- 补全英文、简要解释、再举个例子：
    - [x] 源代码：source code，人们可读写的计算机语言指令，通常为文本文件。
    - [x] 字节码：byte-code
    - [x] 程序：program
    - [x] 编译器：compiler
    - [x] 解释器：Interpreter
    - [x] 操作符（运算符）：operator
    - [x] 操作数：operand
    - [x] 位：bit
    - [x] 字节：byte
    - [x] 类型：type
    - [x] 关键字：key
    - [x] 保留字：reserved word
    - [x] 字面量（文字量）：literal
    - [x] 变量：variable
    - [x] 标识符：identifier
    - [x] 缩进：indent
    - [x] 注释：comments
    - [x] 分号：semicolon
    - [x] 圆括号：parenthesis
    - [x] 方括号：bracket
    - [x] 大括号：braces
- 判断以下说法正确性并解释：
    - [x] `main`是Java的关键字。 否

    - [x] `Class`是Java的关键字。  是

    - [x] 开发Java程序必须用到IDE。否

    - [x] 开发Java程序必须用到JDK。是

    - [x] 运行Java程序必须用到IDE。否

    - [x] 运行Java程序必须用到JDK。否

    - [x] 运行Java程序必须用到JRE。是

      > JDK：Java Development Kit  java开发工具包
      >
      > JRE：Java Runtime Environment  java运行环境，是运行java程序所必需的环境的集合，包含JVM标准实现及Java核心类库
      >
      > JVM：JavaVirtualMachine java虚拟机 用c++写的运行所有java程序的抽象计算机

    - [x] `3D_Game`、`5G-Phone`都可用作Java标识符。 均不可，不能以数字开头，且`-`不能有

    - [x] `int i = '1';`类型不符，会导致语义错误。不会错误

    - [x] `Long n = 1;`因为类型提升和自动装箱特性，可以通过编译。不可以通过编译
- 简述关键字用途：
    - [x] `boolean` 基本数据类型之一，布尔类型
    - [x] `byte, short, int, long` 基本数据类型 字节、短整数、整数、长整数类型
    - [x] `double, float` 基本数据类型，双精度浮点数、单精度浮点数类型
    - [x] `char` 基本数据类型之一，字符类型
    - [x] `void` 声明当前成员方法没有返回值
    - [x] `enum` 声明枚举
- 简述关键字用途：
    - [x] `import` 表明要访问指定的类或包
    - [x] `package` 包
- 阅读以下提示并解释原因：
    - [x] `boolean b = 0; // error: incompatible types: int cannot be converted to boolean`  java中boolean只能赋值为`true`或`false`
    - [x] `float f = 1.0; // error: incompatible types: possible lossy conversion from double to float` 应为`float f = 1.0f` double型不能直接赋值给float类型变量
- 查出下列字符在ASCII/Unicode字符集中的编码（十进制）：
    - [x] `\0`（NUL）：0
    - [x] `\t`（制表）：9
    - [x] `\n`（换行）：10
    - [x] `\r`（回车）：13
    - [x] `0`：48
    - [x] `A`：65
    - [x] `a`：97
    - [x] `~`：126
- 下列各语句暗含的操作（自动装箱、强制转型、类型提升）：
    - [x] `int a = '1';`  
    - [x] `float f = 1L;`  自动类型转换
    - [x] `int i = (int)f;`  强制类型转换
    - [x] `long l = i;` 自动类型转换
    - [x] `Long g = l;` 自动装箱

## 任务1：进制转换（RadixConverter）

- [x] 名词解释
    - [x] 十进制整数字面量，英文是decimal，有些语言支持十进制前缀`0d`。
    - [x] `0b`: 二进制英文是：binary
    - [x] `0o`: 八进制前缀，单词是：Octal
    - [x] `0x`: 十六进制前缀，单词是：Hexadecimal
    
- [x] `short`类型可输入最大值、最小值各是多少？超出范围会有什么结果？

    最小值是-32768（-2^15）； 最大值是32767（2^15 - 1）

```java
import java.util.Scanner;

public class RadixConverter {
  public static void main(String[] args){
    var scn = new Scanner(System.in); 
    int i = scn.nextInt();
    System.out.printf("%x\n",i);//按16进制输出
    System.out.printf("%o\n",i);//按8进制输出
    //2进制
    String s=Integer.toBinaryString(i);
    System.out.println(s);
  }
}
```



## 任务2：求平方根（SquareRoot）

```java
import java.util.Scanner;

public class SquareRoot {
  public static void main(String[] args) {
    var scn = new Scanner(System.in);
    double x = scn.nextDouble();
    System.out.printf("sqrt(%.9f) = %.9f\n", x, Math.sqrt(x));
  }
}
```

- 输入负数结果如何？

  ```
  sqrt(-5.000000000) = NaN
  ```

- 输入非数字结果如何？（例如"abc"） 报错

  ```
  Exception in thread "main" java.util.InputMismatchException
  	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
  	at java.base/java.util.Scanner.next(Scanner.java:1594)
  	at java.base/java.util.Scanner.nextDouble(Scanner.java:2564)
  	at ex02.SquareRoot.main(SquareRoot.java:8)
  ```

- 把变量`x`定义为`float`有什么影响？

  精度

- 上述程序有缺陷（defect），对某些输入会出错（bug）。你能找到并修正吗？

- `var`自动类型推导非常方便，有什么缺点？

  缺点：降低了程序的可读性。

## 任务3：编程求解一元二次方程$$ax^2 + bx + c = 0$$

- 从键盘读入3个系数a、b、c，判断根的情况并计算输出。结果保留9位小数。
- 提示：一元二次方程求根公式：
  $$x_{1,2} = \frac{-b \pm \sqrt{b ^ 2 - 4 a c}}{2a}$$

```java
import java.util.Scanner;

public class equation {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        double discriminant,root1,root2;
        discriminant=Math.pow(b,2)-(4*a*c);
        if(discriminant<0){
            System.out.println("No roots");
        }else if(discriminant==0){
            root1=((-b)+Math.sqrt(discriminant))/2/a;
            System.out.println("root="+String.format("%.9f",root1));
        }else{
            root1=((-b)+Math.sqrt(discriminant))/2/a;
            root2=((-b)-Math.sqrt(discriminant))/2/a;
            System.out.println("root1="+String.format("%.9f",root1));
            System.out.println("root2="+String.format("%.9f",root2));
        }
    }
}
```

## 任务4（选做）：奇偶性（Parity）

- 读入一个整数，是奇数时输出字母`O`、偶数时输出字母`E`，**不用控制语句或条件算符或位运算**。
- 提示：回忆课堂介绍逻辑操作符`&& ||`时与算术操作符的类比。

```java
import java.util.Scanner;

public class Parity {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.println((char)(69+(i%2)*10));//E:69  O：79
    }
}
```

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。

- 学习利用`Scanner`读入数据、`System.out.println`输出结果的基本方法。
- 学习Java**基础类型、变量、表达式、类型转换**等基本概念
- 学习到了用unicode来解题
