# Java程序设计-实验报告-09：图形家族

## 任务0：

- 简述关键字用途：
  - [x] `abstract` 表明类或者成员方法具有抽象属性，用于修改类或方法
  - [x] `extends` 表明一个类型是另一个类型的子类型。对于类，可以是另一个类或者抽象类；对于接口，可以是另一个接口
  - [x] `final `用来说明最终属性，表明一个类不能派生出子类，或者成员方法不能被覆盖，或者成员域的值不能被改变，用来定义常量
  - [x] `implements `表明一个类实现了给定的接口
  - [x] `instanceof `用来测试一个对象是否是指定类型的实例对象
  - [x] `interface` 接口
  
- 判断并解释：
  
  - [x] 构造函数不能是私有的，否则无法构造该类对象。
  
    可以有私有的构造函数，但一定要有一个public的才能构造对象使用
  
- 名词：
  - [x] 封装 即隐藏对象的属性和实现细节，仅对外公开接口，控制在程序中属性的读和修改的访问级别；将抽象得到的数据和行为（或功能）相结合，形成一个有机的整体，也就是将数据与操作数据的源代码进行有机的结合，形成“类”，其中数据和函数都是类的成员。
  - [x] 继承 继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。
  - [x] 多态 多态是同一个行为具有多个不同表现形式或形态的能力。
  - [x] 消息传递 消息传递是进程间数据传递的一种方法，进程采用消息的方法，由发送进程向接收进程的消息队列发送一个消息，接收进程在合适的时候取出。
  
- [x] 列举支持面向对象编程的程序设计语言（5种以上）

  Smalltalk   Eiffel    Java   c++   PHP

## 任务1：抽象类（Shape）

- [x] 代码：

```java
abstract public class Shape {
    protected double side1;
    protected double side2;
    protected double square;
    protected double length;

    public Shape(){}
    public Shape(double side1,double side2){
        this.side1=side1;
        this.side2=side2;
    }

    public abstract double square();
    public abstract double length();
}

```

## 任务2：实体类

- [x] 讨论：圆是特殊的椭圆，正方形是特殊的矩形。设计圆形`Circle`与椭圆`Ellipse`、正方形`Square`与矩形`Rectangle`类继承体系时需要反映集合关系吗？

  可以反映

- [x] 代码：

```java
class Rectangle extends Shape{

    public void setWidth(double width){
        this.side1=width;
    }
    public void setHeight(double height){
        this.side2=height;
    }
    public Rectangle(double side1,double side2) {super(side1,side2);}

    @Override
    public double square() {
        square=side1*side2;
        return square;
    }

    @Override
    public double length() {
        length=(side1+side2)*2;
        return length;
    }
}

class Square extends Rectangle{

    public Square(double side) {super(side,side);}

    @Override
    public double square() {
        square=side1*side2;
        return square;
    }

    @Override
    public double length() {
        length=(side1+side2)*2;
        return length;
    }
}

class Diamond extends Shape{

    public Diamond(double diagonal1,double diagonal2){super(diagonal1,diagonal2);}

    @Override
    public double square() {
        square=side1*side2/2;
        return square;
    }

    @Override
    public double length() {
        length=2*(Math.sqrt(side1*side1+side2*side2));
        return length;
    }
}

class Circle extends Shape{

    public Circle(double r) {
        super(r,r);
    }

    @Override
    public double square() {
        square=Math.PI*side1*side1;
        return square;
    }

    @Override
    public double length() {
        length=2*Math.PI*side1;
        return length;
    }

}
```

## 任务3：排序
- [x] 代码：

```java
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

```

## 任务4：修改排序方法

- [x] 代码：

```java
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
```

## 任务5：DRY - Don't Repeat Yourself（选做）

- [x] 问题：程序中的重复代码有何优缺点？

  可以节省重新写代码的时间  缺少创新改进

- [x] 问题：完成前述实验任务时有哪些相似代码出现？如何消除重复代码？

  将重复代码写成方法直接调用

总结排序

```java
package ex09;

import java.util.ArrayList;

public class sorting {

    //从大到小
    public static void selectionSort1(int[] list) {
        int max;
        int temp;
        for(int index=0;index<list.length-1;index++){
            max=index;
            for(int scan=index+1;scan<list.length;scan++){
                if(list[scan]>list[max]){
                    max=scan;
                }
            }
            temp=list[index];
            list[index]=list[max];
            list[max]=temp;
        }
    }

    //从小到大
    public static void selsectionSort2(int[] list){
        int min;
        int temp;
        for(int index=0;index<list.length-1;index++){
            min=index;
            for(int scan=index+1;scan<list.length;scan++){
                if(list[scan]<min){
                    min=scan;
                }
            }
            temp=list[index];
            list[index]=list[min];
            list[min]=temp;
        }
    }

    //从大到小
    public static void insertionSort1(int[] list){
        for(int index=1;index<list.length;index++){
            int key=list[index];
            int position=index;
            while(position>0&&key>list[position-1]){
                list[position]=list[position-1];
                position--;
            }
            list[position]=key;
        }
    }

    //从小到大
    public static void insertionSort2(int[] list){
        for(int index=1;index<list.length;index++){
            int key=list[index];
            int position=index;
            while(position>0&&key<list[position-1]){
                list[position]=list[position-1];
                position--;
            }
            list[position]=key;
        }
    }
}

```



## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 深入学习了解继承、多态、排序
  - 由于使用了实验8开发的动态数组 改进了实验8的动态数组类 并加深了对此的了解
