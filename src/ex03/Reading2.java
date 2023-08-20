package ex03;

import java.util.Scanner;

public class Reading2 {
  static boolean on_border(int x, int n){
    return x == 0 || x == (n-1);
  }

  public static void main(String[] args){
    var scn = new Scanner(System.in);
    final int n = scn.nextInt();
    for(int i = 0; i < n; ++i){
      for(int j = 0; j < n; ++j){
        System.out.print((on_border(i, n) || on_border(j, n)) ? '#' : '.');
      }
      System.out.print('\n');
    }
  }
}
/* Ex03-Task3: 程序阅读3
 */

/*
5
#####
#...#
#...#
#...#
#####
 */
