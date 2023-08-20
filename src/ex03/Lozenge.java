package ex03;

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
