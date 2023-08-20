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
