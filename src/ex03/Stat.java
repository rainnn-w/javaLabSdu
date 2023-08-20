package ex03;

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
/* Ex03Task1: 统计分析
 */
