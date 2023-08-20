package ex09;

import ex08.ArrayList;

import java.util.Random;

public class Queue2 {

    public static ArrayList shape=new ArrayList();
    public static int n=20;

    public static void main(String[] args) {
        create();
        sortSquare();
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
    }

//按照面积，所有圆形从小到大排列，后面是所有其他图形从大到小排列。
    private static void sortSquare() {
        int count = 0;
        ArrayList circle = new ArrayList();
        ArrayList other = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (shape.get(i) instanceof Circle) {
                circle.append(shape.get(i));
                count++;
            } else {
                other.append(shape.get(i));
            }
        }
        int min = 0;
        Shape temp;
        for (int index = 0; index<count-1; index++) {
            min = index;
            for (int scan = index + 1; scan < count; scan++) {
                double square1 = ((Shape) circle.get(scan)).square();
                double square2 = ((Shape) circle.get(min)).square();
                if (square1 < square2) {
                    min = scan;
                }
            }
            circle.swapPosition(min,index);
        }
        int max=0;
        for (int index = 0; index < n-count-1; index++) {
            max = index;
            for (int scan = index + 1; scan < n-count; scan++) {
                double square1 = ((Shape) other.get(scan)).square();
                double square2 = ((Shape) other.get(max)).square();
                if (square1 > square2) {
                    max = scan;
                }
            }
            other.swapPosition(max,index);
        }

        for(int z=0;z<count;z++){
            shape.update(circle.get(z),z);
        }
        for(int z=0;z<n-count;z++){
            shape.update(other.get(z),z+count);
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
