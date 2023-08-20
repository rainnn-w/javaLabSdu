package ex05;

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
