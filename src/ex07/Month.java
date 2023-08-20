package ex07;

import java.util.Scanner;

public class Month {
    public static void main(String[] args ){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份");
        int year=sc.nextInt();
        System.out.println("请输入月份");
        int month=sc.nextInt();

        //1583.1.1星期六
        //1900.1.1星期一
        System.out.println("一\t二\t三\t四\t五\t六\t日");

        int totalDay=getTotalDay(year,month);
        int space=(totalDay+5)%7;
        int sum=space;
        for(int i=1;i<=space;i++){
            System.out.print("\t");
        }
        for(int i=1;i<=getMonthDay(year,month);i++){
            System.out.print(i+"\t");
            sum++;
            if(sum%7==0){
                System.out.println();
                sum=0;
            }
        }
    }

    //判断闰年 是：true  否：false
    public static boolean leap(int year){
        boolean result=false;
        if(year%400==0){
            result=true;
        }else if((year%100!=0)&&(year%4==0)){
            result=true;
        }
        return result;
    }

    public static int getYearDay(int year){
        if(leap(year)){
            return 366;
        }else{
            return 365;
        }
    }

    public static int getMonthDay(int year,int month){
        if(leap(year)){
            int[] day={31,29,31,30,31,30,31,31,30,31,30,31};
            return day[month-1];
        }else{
            int[] day={31,28,31,30,31,30,31,31,30,31,30,31};
            return day[month-1];
        }
    }

    public static int getTotalDay(int year,int month){
        int totalDays=0;
        for(int i=1583;i<year;i++){
            totalDays+=getYearDay(i);
        }
        for(int i=1;i<month;i++){
            totalDays+=getMonthDay(year,i);
        }
        return totalDays;
    }

}
