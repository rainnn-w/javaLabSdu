# Java程序设计-实验报告-04：计算器

## 任务0：

- 简述关键字用途：
  
  - [x] `new` 创建新对象
- 简要解释
  - [x] 编译期 也叫前期，即源文件由编译器编译成字节码（ByteCode）
  - [x] 运行期（run-time） 也叫后期，即字节码由java虚拟机解释运行。
- 判断以下说法正确性并解释：
  
  - [x] 注释有助于他人理解程序，但过多的注释会影响程序的运行效率。
  
    否

## 任务1：前缀计算器（PrefixCalculator）

- 自行创建`data1.txt, data2.txt, data3.txt`文件。

- [x] 以调试模式（Debug）运行并分析该程序，写出该程序的作用。

- 补充完整该程序，使得其可以正确计算data.txt中的所有运算，并友好的输出结果。

- 修改该程序，使其支持data1.txt数据处理。

- 修改data1.txt存放路径或数据内容，使程序发生以下错误，截图并说明你如何实现的。
  - 计算结果溢出
  
  - 数据处理异常  修改数据
  
    ![image-20230219144317837](D:\Files\Study\Java\my-lab\src\ex04\image-20230219144317837.png)
  
  - 文件未找到异常 修改文件路径名
  
    ![image-20230219144429641](D:\Files\Study\Java\my-lab\src\ex04\image-20230219144429641.png)
  
- Data1.txt

  ```txt
  * 12 56
  
  - 213 33
  
  * 21 32
  / 15 4
  / 15 0
  
  + 22 6
  ```

- 问题：数据中的空行需要特殊处理吗？ 不需要（按照以下代码）

- 代码：

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrefixCalculator {
  private static int calculate(char op, int a, int b) {
    int x = 0;
    switch (op) {
      case '+':
        return a+b;
      case '-':
        return a-b;
      case '*':
        return a*b;
      case '/':
        if(b!=0){
          return a / b; // FIXME: 检查除零的情况。
        }
      // FIXME: 处理无效字符。
      default:
        return x;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner fileScan;
    fileScan=new Scanner(new File("./src/ex04/Data1.txt"));
    while (fileScan.hasNext()) {
      String ops = fileScan.next();
      char op = ops.charAt(0);
      int a = fileScan.nextInt();
      int b = fileScan.nextInt();
      System.out.printf("%d %c %d = %d\n", a, op, b, calculate(op, a, b));
    }
  }
}
/* Ex04-Task1: 前缀表达式计算器
 */
```

## 任务2：中缀表达式计算器（InfixCalculator）

- [x] 任务2：中缀表达式计算器（InfixCalculator）

  - TODO

  ```java
    /*
    要求
    6 修改程序，使其支持data2.txt
    Data2.txt处理伪代码，供参考：
    对一个操作数 a
    读第一个运算符 op1
    读第二个操作数 b
    while hasNext{
    读第二个运算符 op2
    读第三个操作数 c
    if (op1 为乘除法) 计算 a = a op1 b; op1 = op2; b = c \\ 归并 op1
    else
    if （op2 为乘除法）计算 b = b op2 c;  \\ 归并op2
    else ...\\归并op1
    }
    归并op1 结束。
  
    提示：只要没有括号，每次看两个运算符，处理掉一个，剩下的一个与下一个又凑成两个运算符
    */
  ```

    - Data2.txt

    ```txt
    12 + 15 - 13
    17 - 18 + 24
    33 * 6 / 6
    55 / 10 + 2
    ```

    - Data3.txt

    ```txt
    2 + 3 *4
    2 + 3 + 2* 3 + 2
    3 *4 - 2* 3
    1234 - 567 / 7 + 22
    ```


- 代码：

```java
package ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrefixCalculator {
  private static int calculate(char op, int a, int b) {
    int x = 0;
    switch (op) {
      case '+':
        return a+b;
      case '-':
        return a-b;
      case '*':
        return a*b;
      case '/':
        if(b!=0){
          return a / b; // FIXME: 检查除零的情况。
        }
      // FIXME: 处理无效字符。
      default:
        return x;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner fileScan;
    fileScan=new Scanner(new File("./src/ex04/Data1.txt"));
    while (fileScan.hasNext()) {
      String ops = fileScan.next();
      char op = ops.charAt(0);
      int a = fileScan.nextInt();
      int b = fileScan.nextInt();
      System.out.printf("%d %c %d = %d\n", a, op, b, calculate(op, a, b));
    }
  }
}
/* Ex04-Task1: 前缀表达式计算器
 */

```

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 学习、理解Scanner扩展应用
  - 尝试阅读理解简单的分支、循环程序
  - 更深入学习的利用Debug工具分析程序控制流程
  - 简单的文本处理
