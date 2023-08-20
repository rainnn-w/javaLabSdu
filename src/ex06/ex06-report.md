# Java程序设计-实验报告-06：密码破译

## 任务0：

- [x] 问题：如何生成`[a, b]`范围内均匀分布的伪随机整数？

  `(int)(Math.random()*(b-a))+(int)a;`

- [x] 问题：伪随机数生成器的**伪**是什么意思？

  java是通过一个“种子”，然后经过算法计算产生的随机数。如果种子相同，则产生的随机数序列也就相同，这不是我们所想的真正的随机数。

## 任务1：频数统计

- [x] 代码：

```java
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

```

```java
package ex06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) throws IOException {
        int answer = 3;
        answer=answer%26;//规定一下：answer在-26到26之前（answer=i%26）
        Scanner fileScan, scn;
        fileScan = new Scanner(new File("./src/ex06/text"));
        int a, b=0;
        char c;
        String line;
        String text = "";
        File file = new File("./src/ex06/ciphertext.txt");
        FileWriter writer = null;
        try {
            //检查目标文件是否存在，不存在则创建
            if (!file.exists()) {
                file.createNewFile();// 创建目标文件
            }
            //覆盖
            writer = new FileWriter(file, false);

            while (fileScan.hasNext()) {
                line= fileScan.nextLine();
                scn=new Scanner(line);
                while (scn.hasNext()) {
                    text = scn.next();
                    for (int i = 0; i < text.length(); i++) {
                        a = (int) (text.toLowerCase().charAt(i));
                        if (a + answer > 122) {
                            b = a + answer - 122 + 97 - 1;
                        } else if(a+answer<=122&&a+answer>=97){
                            b = a + answer;
                        }else if(a+answer<97){
                            b=122+a+answer-97+1;
                        }
                        c = (char) b;
                        writer.append(c);
                    }
                    writer.append(" ");
                }
                writer.append("\n");
            }
                writer.flush();
            } catch(IOException e){
                e.printStackTrace();
            } finally{
                if (null != writer)
                    writer.close();
            }
        }
    }

```



## 任务2：破译凯撒密码（Caesar cipher）

- [x] 代码：

```java
package ex06;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Plain {
    public static void main(String[] args) throws IOException {
        int answer = -3;
        answer=answer%26;//规定一下：answer在-26到26之前（answer=i%26）
        Scanner fileScan, scn;
        fileScan = new Scanner(new File("./src/ex06/ciphertext.txt"));
        int a, b=0;
        char c;
        String line;
        String text = "";
        File file = new File("./src/ex06/plaintext.txt");
        FileWriter writer = null;
        try {
            //检查目标文件是否存在，不存在则创建
            if (!file.exists()) {
                file.createNewFile();// 创建目标文件
            }
            //覆盖
            writer = new FileWriter(file, false);

            while (fileScan.hasNext()) {
                line= fileScan.nextLine();
                scn=new Scanner(line);
                while (scn.hasNext()) {
                    text = scn.next();
                    for (int i = 0; i < text.length(); i++) {
                        a = (int) (text.toLowerCase().charAt(i));
                        if (a + answer > 122) {
                            b = a + answer - 122 + 97 - 1;
                        } else if(a+answer<=122&&a+answer>=97){
                            b = a + answer;
                        }else if(a+answer<97){
                            b=122+a+answer-97+1;
                        }
                        c = (char) b;
                        writer.append(c);
                    }
                    writer.append(" ");
                }
                writer.append("\n");
            }
            writer.flush();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            if (null != writer)
                writer.close();
        }
    }
}

```

```java
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

```

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 综合运用控制流程、预定义类。
  - 掌握`String, Random`等类的用法。
  - 学习了解了凯撒密码
