package ex05;

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
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public double deposit(double money){
        balance=balance+money;
        return balance;
    }
    public double withdraw(double money){
        balance=balance-money;
        return balance;
    }
    public double addInterest(){
        balance+=(balance*rate);
        return balance;
    }
    public String toString(){
        NumberFormat fmt=NumberFormat.getCurrencyInstance();
        return number+"\t"+name+"\t"+fmt.format(balance);
    }
}
