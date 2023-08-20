package ex09;

import ex08.ArrayList;

import java.util.Random;

public class Queue {

    public static ArrayList shape=new ArrayList();
    public static int n=20;

    public static void main(String[] args) {
        create();
        sortSquare1();
        System.out.println("Square!");
        for (int i = 0; i < n; i++) {
            if (shape.get(i) instanceof Circle) {
                System.out.print("Circle\t");
            } else if (shape.get(i) instanceof Diamond) {
                System.out.print("Diamond\t");
            } else if (shape.get(i) instanceof Rectangle) {
                System.out.print("Rectangle\t");
            } else if (shape.get(i) instanceof Square) {
                System.out.print("Square\t");
            }
            System.out.println(((Shape) (shape.get(i))).square());
        }
        System.out.println();
        sortLength1();
        System.out.println("Length!");
        for(int i=0;i<20;i++){
            if(shape.get(i) instanceof Circle){
                System.out.print("Circle\t");
            }else if(shape.get(i) instanceof Diamond){
                System.out.print("Diamond\t");
            }
            else if(shape.get(i) instanceof Rectangle){
                System.out.print("Rectangle\t");
            }else if(shape.get(i) instanceof Square){
                System.out.print("Square\t");
            }
            System.out.println(((Shape)(shape.get(i))).length());
        }
        System.out.println();
        sortSquare2();
        System.out.println("Square2!");
        for(int i=0;i<20;i++){
            if(shape.get(i) instanceof Circle){
                System.out.print("Circle\t");
            }else if(shape.get(i) instanceof Diamond){
                System.out.print("Diamond\t");
            }
            else if(shape.get(i) instanceof Rectangle){
                System.out.print("Rectangle\t");
            }else if(shape.get(i) instanceof Square){
                System.out.print("Square\t");
            }
            System.out.println(((Shape)(shape.get(i))).square());
        }
        System.out.println();
        sortLength2();
        System.out.println("Length2!");
        for(int i=0;i<20;i++){
            if(shape.get(i) instanceof Circle){
                System.out.print("Circle\t");
            }else if(shape.get(i) instanceof Diamond){
                System.out.print("Diamond\t");
            }
            else if(shape.get(i) instanceof Rectangle){
                System.out.print("Rectangle\t");
            }else if(shape.get(i) instanceof Square){
                System.out.print("Square\t");
            }
            System.out.println(((Shape)(shape.get(i))).length());
        }

    }


    //选择排序 面积 从大到小
    private static void sortSquare1() {
        int max;
        Shape temp;
        for(int index=0;index<n-1;index++){
            max=index;
            for(int scan=index+1;scan<n;scan++){
                double square1=((Shape)shape.get(scan)).square();
                double square2=((Shape)shape.get(max)).square();
                if (square1>square2) {
                    max=scan;
                }
            }
            temp=(Shape)shape.get(index);
            shape.update((Shape)shape.get(max),index);
            shape.update(temp,max);
        }
    }

    //选择排序 面积 从小到大
    private static void sortSquare2() {
        int min;
        Shape temp;
        for(int index=0;index<n-1;index++){
            min=index;
            for(int scan=index+1;scan<n;scan++){
                double square1=((Shape)shape.get(scan)).square();
                double square2=((Shape)shape.get(min)).square();
                if (square1<square2) {
                    min=scan;
                }
            }
            temp=(Shape)shape.get(index);
            shape.update((Shape)shape.get(min),index);
            shape.update(temp,min);
        }
    }

    //选择排序 周长 从大到小
    private static void sortLength1() {
        int max;
        Shape temp;
        for(int index=0;index<n-1;index++){
            max=index;
            for(int scan=index+1;scan<n;scan++){
                double length1=((Shape)shape.get(scan)).length();
                double length2=((Shape)shape.get(max)).length();
                if (length1>length2) {
                    max=scan;
                }
            }
            temp=(Shape)shape.get(index);
            shape.update((Shape)shape.get(max),index);
            shape.update(temp,max);
        }
    }

    //选择排序 周长 从小到大
    private static void sortLength2() {
        int min;
        Shape temp;
        for(int index=0;index<n-1;index++){
            min=index;
            for(int scan=index+1;scan<n;scan++){
                double length1=((Shape)shape.get(scan)).length();
                double length2=((Shape)shape.get(min)).length();
                if (length1<length2) {
                    min=scan;
                }
            }
            temp=(Shape)shape.get(index);
            shape.update((Shape)shape.get(min),index);
            shape.update(temp,min);
        }
    }

    public static void create(){
        Random random=new Random();
        for(int i=0;i<n;i++){
            switch(random.nextInt(4)){
                case 0:
                    Circle a=new Circle(random.nextDouble()*10);
                    shape.append(a);
                    break;
                case 1:
                    Diamond b=new Diamond(random.nextDouble()*10, random.nextDouble()*10);
                    shape.append(b);
                    break;
                case 2:
                    Square c=new Square(random.nextDouble()*10);
                    shape.append(c);
                    break;
                case 3:
                    Rectangle d=new Rectangle(random.nextDouble()*10,random.nextDouble()*10);
                    shape.append(d);
                    break;
            }
        }
    }

}
