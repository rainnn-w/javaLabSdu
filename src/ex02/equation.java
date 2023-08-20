package ex02;

import java.util.Scanner;

public class equation {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        double discriminant,root1,root2;
        discriminant=Math.pow(b,2)-(4*a*c);
        if(discriminant<0){
            System.out.println("No roots");
        }else if(discriminant==0){
            root1=((-b)+Math.sqrt(discriminant))/2/a;
            System.out.println("root="+String.format("%.9f",root1));
        }else{
            root1=((-b)+Math.sqrt(discriminant))/2/a;
            root2=((-b)-Math.sqrt(discriminant))/2/a;
            System.out.println("root1="+String.format("%.9f",root1));
            System.out.println("root2="+String.format("%.9f",root2));
        }
    }

}
