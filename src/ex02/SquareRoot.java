package ex02;

import java.util.Scanner;

public class SquareRoot {
  public static void main(String[] args) {
    var scn = new Scanner(System.in);
    double x = scn.nextDouble();
    System.out.printf("sqrt(%.9f) = %.9f\n", x, Math.sqrt(x));
  }
}
/* Ex02-Task2: 求平方根
- 输入负数结果如何？
- 输入非数字结果如何？（例如"abc"）
- 把变量`x`定义为`float`有什么影响？
- 上述程序有缺陷（defect），对某些输入会出错（bug）。你能找到并修正吗？
 */
