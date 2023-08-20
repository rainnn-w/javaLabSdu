# Java程序设计-实验报告-03：控制结构

好消息：在学过控制结构之后，理论上的计算能力就完备了。
从教材进度可以看出，还有很多的内容。后续都是为了更好地控制“复杂度”。

## 任务0：

- 简述关键字用途：
  - [x] `break `提前跳出一个块
  - [x] `case` 用在switch语句之中，表示其中的一个分支
  - [x] `continue` 回到一个块的开始处（跳出本次循环，进入下一次）
  - [x] `default`  默认，例如：用在switch语句中，表明一个默认的分支。Java8 中也作用于声明接口函数的默认实现
  - [x] `do `用在do-while循环结构中
  - [x] `else `用在条件语句中，表明当条件不成立时的分支
  - [x] `for `一种循环结构的引导词
  - [x] `if `条件语句的引导词
  - [x] `return `从成员方法中返回数据
  - [x] `switch `分支语句结构的引导词
  - [x] `while `用在循环结构中
  
- 判断以下说法正确性并解释：
  - [x] `switch`语句必须有`break`。 否
  - [x] `switch`语句必须有`default`分支。 否
  - [x] `switch`语句不能有多个`default`分支。 是
  - [x] `default`分支必须出现在`switch`语句的最后。 否。default可以随意与case语句更换位置，不论其在哪，都是最后被执行
  - [x] `default`分支不能有`break`。否
  - [x] `break`只能出现在`switch`语句中。否 循环
  - [x] `continue`只能出现在`for`语句中。否 while等
  - [x] CPU主频指每秒多少个“时钟周期”，即每秒能执行多少次循环语句。
  
- CPU主频指每秒多少个“时钟周期”，即每秒能执行多少次循环语句。

- 简答：
  - [x] 假设CPU主频为3.0GHz，导线使用铜材质制造，那么一个时钟周期内信号的最大传输距离约多少厘米？
  
    铜线中的电信号传播速度大约为2.3*10 (8次方)m/s,
  
    最大传输距离约为(2.3/3.0)*10^7 cm
  
  - [x] CPU的“分支预测”功能有什么作用？
  
    解决处理分支指令（if-then-else)导致流水线失败的数据处理方法，由[CPU](https://baike.baidu.com/item/CPU/120556?fromModule=lemma_inlink)来判断程序分支的进行方向，能够加快运算速度。
  
  - [x] 分支条件应设计为大概率还是小概率成立？（`if`部分）为什么？
  
    大概率成立  高概率命中可以提高性能
  
- 测试：
  
  - [x] 以下程序在你的电脑上运行需要多少秒？（精确到1位小数即可）
  
    1s208ms

```java
public class LoopTest {
  public static void main(String[] args) {
    long s = 0;
    for(long i = 0; i <= 1000000000; ++i){ // 循环10亿次
      s += i;
    }
    System.out.printf("%d", s); // 输出应为：500000000500000000
  }
}
```

## 任务1：程序阅读（Reading1）

- [x] 阅读`ex03/Reading1.java`程序，推测其功能，执行并验证你的结论。

  ```java
  /*
  5
  #####
  #...#
  #...#
  #...#
  #####
   */
  ```

## 任务2：程序阅读（Reading2）

- [x] 阅读`ex03/Reading2.java`程序，并与上步比较两种写法的优缺点。

个人认为第二种简洁但较难理解

## 任务3：统计分析

- [x] 随机生成10个`[1, 100]`内的整数，统计**总和、算术平均数，最大值，最小值，第二大数值、第二小数值**并输出。
  - 平均数输出时保留3位小数。
  - 参考代码框架完成。

```java
import java.util.Random;

public class Stat {
  public static void main(String[] args){
    var rng = new Random();
    final int n = 10;
    int sum = 0, max1 = 0, max2 = 0, min1 = 100, min2 = 100; // FIXME: 最小值统计量应怎样初始化？
    for(int i = 0; i < n; i++){
      int x = (rng.nextInt(100)+1) ; // FIXME: 鼠标指向nextInt()方法，阅读说明，修正错误。
      sum += x;
      if(min1 > x){
        min1 = x;
      }else if(min2>x){
        min2=x;
      }
      if(max1<x){
        max1=x;
      }else if(max2<x){
        max2=x;
      }
    }

    // TODO: 输出总和、算术平均数（输出时保留3位小数），最大值，最小值，第二大数值、第二小数值。
    System.out.printf("sum  = %d\n", sum);
    System.out.printf("avg  = %.3f\n", (double)sum / n); // FIXME: 修正错误。
    System.out.printf("max1 = %d\n", max1);
    System.out.printf("max2 = %d\n", max2);
    System.out.printf("min1 = %d\n", min1);
    System.out.printf("min2 = %d\n", min2);
  }
}
```



## 任务4：绘制菱形（Lozenge）

- [x] 编程读入正整数参数n（小于10），用`*`打印边长为n的空心菱形。
  - 直接做本题如感觉困难，可以把实验说明的“循环结构渐进练习”练完再试试。

```java
import java.util.Scanner;

public class Lozenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        for (int y = 1; y <= (2 * n - 1); y++) {
            for (int x = 1; x <= (2 * n - 1); x++) {
                System.out.print(on_border(x, y, n) ? "*" : " ");
            }
            System.out.print('\n');
        }

    }

    private static boolean on_border(int x, int y, int n) {
        for (int i = 0; i <= n - 1; i++) {
            if (((x == (n - i)) || x == (n + i)) && y == i + 1) {
                return true;
            } else if (((x == (i)) || x == (2 * n - i)) && y == (n - 1 + i)) {
                return true;
            }else if(x==n&&y==(2*n-1)){
                return true;
            }
        }
        return false;
    }
}
/*
n=3
  *
 * *
*   *
 * *
  *

n=5
    *
   *  *
  *    *
 *      *
*        *
 *      *
   *   *
    * *
     *


 */
```

## 任务5（选做）：命令行参数（Command-Line Arguments）

- [x] 将上步的程序改造成可以读入尺寸`n`、字符`c`两个参数，用指定的字符`c`绘制边长为`n`的菱形。
  - 用`main(String[] args)`的`args`参数，从命令行获取参数`n, c`。
  - 提示：固定输出`*`字符的方式又叫“硬编码（hard-coded）”，俗称“写死在程序里”。而参数化是提高程序灵活性的办法。

```java
public class Lozenge2 {
    public static void main(String[] args) {
        String n0 = args[0];
        int n=Integer.parseInt(n0);
        for(int y=1;y<=(2*n-1);y++){
            for(int x=1;x<=(2*n-1);x++){
                System.out.print(on_border(x,y,n)?args[1]:"");
            }
            System.out.print('\n');
        }

    }

    private static boolean on_border(int x, int y, int n) {
        for (int i = 0; i <= n - 1; i++) {
            if (((x == (n - i)) || x == (n + i)) && y == i + 1) {
                return true;
            } else if (((x == (i)) || x == (2 * n - i)) && y == (n - 1 + i)) {
                return true;
            }else if(x==n&&y==(2*n-1)){
                return true;
            }
        }
        return false;
    }

```

## 补充

- [x] foreach循环写法

```java
import java.util.*;

public class MyClass {
  public static void main(String[] args) {
    var scn = new Scanner(System.in);
    int[] a = new int[5];
    for(var i : a){
      a[i] = scn.nextInt();
      System.out.printf("a[%d] = %d\n", i, a[i]);
    }
  }
}
```

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 学习掌握阅读理解简单的分支、循环程序。
  
  - 学习掌握分支、循环的使用。
  
  - 学习掌握命令行参数用法。
  
    
