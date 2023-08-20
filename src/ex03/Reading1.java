package ex03;

import java.util.Scanner;

public class Reading1 {
  public static void main(String[] args){
    var scn = new Scanner(System.in);
    final int n = scn.nextInt(); // TODO: 声明为final有什么用处？
    for(int i = 0; i < n; ++i){
      for(int j = 0; j < n; ++j){
        if(i == 0 || i == (n-1) || j == 0 || j == (n-1)){
          System.out.print('#');
        }else{
          System.out.print('.');
        }
      }
      System.out.print('\n');
    }
  }
}
/* Ex03-Task2: 程序阅读2
 */

/*
5
#####
#...#
#...#
#...#
#####
 */
