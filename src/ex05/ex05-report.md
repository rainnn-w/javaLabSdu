# Java程序设计-实验报告-05：交易模拟

## 任务0：

- 简述关键字用途：
  - [x] `class `声明一个类
  - [x] `private` 一种访问控制方式：私用模式  仅对本类或者其外部类公开
  - [x] `protected ` 一种访问控制方式：保护模式  对于其子类，或者同一个包中的类可见protected成员，在其他包中只能通过继承的方式来使用
  - [x] `public` 一种访问控制方式：共用模式  类公开可见（成员）数据、方法公开可见
  - [x] `static `表明具有静态属性
  - [x] `super` 表明当前对象的父类型的引用或者父类型的构造方法
  - [x] `this` 指向当前实例对象的引用

## 任务1：银行账户类

- [x] 问题：请简述设计思路、开发中遇到的典型问题和解决方法。

  确定对象的属性----创建构造方法----按照需求在类中添加其他方法----测试类----创建对象、调用方法----编译运行----改bug 

- [x] 代码：

```java
import java.util.Random;
import java.util.Scanner;

public class Transactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number;
        String name;
        double balance;
        Random random = new Random();
        double money;
        //创建用户
        System.out.println("请依次输入账号 用户名 余额");
        number = sc.nextLong();
        name = sc.next();
        balance = sc.nextDouble();
        Account user1 = new Account(number, name, balance);
        System.out.println("请依次输入账号 用户名 余额");
        number = sc.nextLong();
        name = sc.next();
        balance = sc.nextDouble();
        Account user2 = new Account(number, name, balance);
        //模拟交易
        money = random.nextDouble() * 10000;
        System.out.println(user1.getName() + "存入" + money + "元");
        user1.deposit(money);
        System.out.println(user1);
        money = random.nextDouble() * 10000;
        System.out.println(user1.getName() + "取出" + money + "元");
        if (money > user1.getBalance()) {
            System.out.println("您的余额不足！");
        } else {
            user1.withdraw(money);
            System.out.println(user1);
        }
        money = random.nextDouble() * 10000;
        System.out.println(user2.getName() + "存入" + money + "元");
        user2.deposit(money);
        System.out.println(user1);
        money = random.nextDouble() * 10000;
        System.out.println(user2.getName() + "取出" + money + "元");
        if (money > user2.getBalance()) {
            System.out.println("您的余额不足！");
        } else {
            user2.withdraw(money);
            System.out.println(user2);
        }
    }
}
```

```java
import java.text.NumberFormat;

public class Account {
    private final double rate=0.03;
    private long number;
    private String name;
    private double balance;

    public Account(long number,String name,double balance){
        this.balance=balance;
        this.name=name;
        this.number=number;
    }
/**
 *@return 余额
 */
    public double getBalance() {
        return balance;
    }
/**
 *@return 用户名
 */
    public String getName() {
        return name;
    }
/**
 *@param money 存入金额
 *@return 存入后余额
 */
    public double deposit(double money){
        balance=balance+money;
        return balance;
    }
/**
 *@param money 取出金额
 *@return 取出后余额
 */   
    public double withdraw(double money){
        balance=balance-money;
        return balance;
    }
/**
 *@return 获得利息后余额
 */
    public double addInterest(){
        balance+=(balance*rate);
        return balance;
    }

    public String toString(){
        NumberFormat fmt=NumberFormat.getCurrencyInstance();
        return number+"\t"+name+"\t"+fmt.format(balance);
    }
}

```

## 任务2：JavaDoc

- [x] 问题：简述常用的JavaDoc注释写法、能够识别的特殊注释关键字等。

  写在类上的文档标注一般分为三段：

  - 第一段：概要描述，通常用一句或者一段话简要描述该类的作用，以英文句号作为结束
  - 第二段：详细描述，通常用一段或者多段话来详细描述该类的作用，一般每段话都以英文句号作为结束
  - 第三段：文档标注，用于标注作者、创建时间、参阅类等信息

  ```java
  /**
   *
   *
   */
  ```

- [x] 请在任务1的银行账户类以及各方法前添加JavaDoc注释。

## 任务3（选做）：测试驱动开发（test-driven development, TDD）

- [ ] 问题：断言（`assert`）的功能和用法？如何启用断言功能（运行参数或IDEA的选项）？

  断言是一种除错机制，用于验证代码是否符合编码人员的预期。编码人员在开发期间应该对函数的参数、代码中间执行结果合理地使用断言机制，确保程序的缺陷尽量在测试阶段被发现。

  菜单--run--Run子窗口选择需要开启断言的程序--edit--出现“Edit configuration settings"编辑窗口--VM option中输入“-ea“--apply

- [x] 问题：掌握单元测试（unit testing）的概念。

  单元测试在软件开发项目的编码阶段进行，以测试应用程序的各个单元。它旨在测试软件代码的每个单元是否按要求执行。单元可以是面向对象语言中的类或类方法，也可以是过程和功能软件语言中的过程或函数。
  单元测试需要快速运行，因此它们在没有外部进程或系统的情况下独立运行。

- [x] 在账户程序中创建单元测试静态方法`test()`，用断言测试任务1、2要求的功能点。

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 掌握`String`、`math`等常用类库的使用方法。
  - 熟悉面向对象编程（OOP）的概念。
  - 掌握自定义类的一般方法。
  - 学习了解了javadoc注释是编写规则和具体使用
  - 学习了解断言assert
  - 了解测试类的写法
