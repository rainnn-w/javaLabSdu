package ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InfixCalculator {
  public static void main(String[] args) throws FileNotFoundException {
    var input_file = new File("./src/ex04/Data3.txt");
    var scn = new Scanner(input_file);
    int a, b, c = 0; // FIXME: 变量作用域应尽可能小，临到使用时再声明。
    String op1, op2;
    while (scn.hasNext()) {
      a = scn.nextInt();
      op1 = scn.next();
      b = scn.nextInt();
      System.out.print(a + op1 + b);
      while (true) {
        op2 = scn.next();
        c = scn.nextInt();
        System.out.print(op2 + c);
        if (op1.equals("*")) {
          a = a * b;
          op1 = op2;
          b = c;
        } else if (op1.equals("/")) {
          a = a / b;
          op1 = op2;
          b = c;
        } else if (op2.equals("*")) {
          b = b * c;
        } else if (op2.equals("/")) {
          b = b / c;
        } else if (op1.equals("+")) {
          a = a + b;
          op1 = op2;
          b = c;
        } else if (op1.equals("-")) {
          a = a - b;
          op1 = op2;
          b = c;
        }
        if(scn.hasNextInt()||!scn.hasNext()){
          if(op1.equals("+"))a=a+b;
          else if(op1.equals("-"))a=a-b;
          else if(op1.equals("*"))a=a*b;
          else if(op1.equals("/"))a=a/b;
          System.out.print("=" + a);
          System.out.println();
          break;
        }
      }
    }

    // FIXME:（选做）Java对本身管理的资源有废料回收（GC）机制。
    //  但外部资源如文件句柄、数据库连接、网络连接依靠GC释放可能不够及时。
    //  对长期运行的程序，忘记关闭外部资源可能造成“资源泄露”。
    //  搜索Java的try-with-resources语法并改写scn的创建和关闭。

  }
}
/* Ex04-Task2: 中缀表达式计算器
 */
