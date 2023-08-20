package ex02;

import java.util.Scanner;

public class Parity {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.println((char)(69+(i%2)*10));//E:69  O：79
    }
}
