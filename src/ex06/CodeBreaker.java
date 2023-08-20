package ex06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CodeBreaker {
  public static void main(String[] args) throws IOException {
    int answer,max=0;
    char maxChar='a';
    Scanner fileScan, scn;
    fileScan = new Scanner(new File("./src/ex06/ciphertext.txt"));
    Integer[] total = new Integer[26];
    int a,b;
    for (int i = 0; i <= 25; i++) {
      total[i] = 0;
    }
    String text = "";
    while (fileScan.hasNext()) {
      text = fileScan.next();
      for (int i = 0; i < text.length(); i++) {
        a = (int) (text.toLowerCase().charAt(i)) - 97;
        if (a >= 0 && a <= 25) {
          total[a]++;
        }
      }
    }
    for (int i = 0; i <= 25; i++) {
      if(total[i]>max){
        max=total[i];
        maxChar=(char)(i+97);
      }
    }

    answer=(int)maxChar-(int)'e';

  }
}
/* Ex06-Task2: 密码破译
 */
