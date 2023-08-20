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
