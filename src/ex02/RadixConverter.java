package ex02;

import java.util.Scanner;

//任务1
public class RadixConverter {
  public static void main(String[] args){
    var scn = new Scanner(System.in); // var是什么意思？有别的写法吗？
    int i = scn.nextInt();
    System.out.printf("%x\n",i);//按16进制输出
    System.out.printf("%o\n",i);//按8进制输出
    //2进制
    String s=Integer.toBinaryString(i);
    System.out.println(s);
  }
}
/* Ex02-Task1: 进制转换
- 初始按十六进制输出，请改成按八进制输出。
 */

//int范围：-2147483648～2147483647
