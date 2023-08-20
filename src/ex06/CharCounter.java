package ex06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharCounter {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner fileScan;
    fileScan=new Scanner(new File("./src/ex06/text"));
    Integer[] total=new Integer[26];
    Integer sum=0;
    Integer a;
    for(int i=0;i<=25;i++){
      total[i]=0;
    }
    String text="";
    while(fileScan.hasNext()){
      text=fileScan.next();
      for(int i=0;i<text.length();i++){
        a=(int)(text.toLowerCase().charAt(i))-97;
        if(a>=0&&a<=25) {
          total[a]++;
          sum++;
        }
      }
    }
    for(int i=0;i<=25;i++){
      System.out.print((char)(97+i)+":");
      System.out.printf("%.6f",((double)total[i]/sum));
      System.out.println();
    }
  }
}

/*
可知26个字母使用频率是（降序）：

        ETAON RISHD LFCMU GYPWB VKJXQ Z

        所以，直接筛选密文中出现频率最高的字母

        并将其与‘e’的ASCII码相减

        即可大致推测出凯撒密码的位移值

 */
