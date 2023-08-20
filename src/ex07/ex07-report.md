# - Java程序设计-实验报告-07：万年历

## 任务1：月历

- [x] 代码：

```java
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

```

## 任务2：输入一个月份，同时输出该月起始的两个月的日历，要求两个月的日历水平排列而非上下排列。

- [x] 代码：

```java
import java.util.Scanner;

public class TwoMonth {
    public static void main(String[] args) {
        int year1, year2, month1, month2;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        year1 = sc.nextInt();
        System.out.println("请输入月份");
        month1 = sc.nextInt();
        if (month1 == 12) {
            year2 = year1 + 1;
            month2 = 2;
        } else {
            year2 = year1;
            month2 = month1 + 1;
        }

        //1583.1.1星期六
        //1900.1.1星期一
        System.out.print("一\t二\t三\t四\t五\t六\t日");
        System.out.print("\t\t\t");
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        for(int l=1;l<=6;l++) {
            getLine(year1,month1,l);
            System.out.print("\t\t");
            getLine(year2,month2,l);
            System.out.println();
        }


    }

    public static void getLine(int year, int month, int line) {
        int totalDay = getTotalDay(year, month);
        int space = (totalDay + 5) % 7;
        int sum = space;
        int i = 1;
        if (line == 1) {
            for (int z = 1; z <= space; z++) {
                System.out.print("\t");
            }
            for (; i <= getMonthDay(year, month); i++) {
                System.out.print(i + "\t");
                sum++;
                if (sum % 7 == 0) {
                    break;
                }
            }
        } else {
            sum=0;
            for (i=(7-space)+7*(line-2)+1; i <=(42-space); i++) {
                if(i <= getMonthDay(year, month)) {
                    System.out.print(i + "\t");
                }else {
                    System.out.print(" " + '\t');
                }
                sum++;
                if (sum % 7 == 0) {
                    break;
                }
            }
        }
    }


        //判断闰年 是：true  否：false
        public static boolean leap ( int year){
            boolean result = false;
            if (year % 400 == 0) {
                result = true;
            } else if ((year % 100 != 0) && (year % 4 == 0)) {
                result = true;
            }
            return result;
        }

        public static int getYearDay ( int year){
            if (leap(year)) {
                return 366;
            } else {
                return 365;
            }
        }

        public static int getMonthDay ( int year, int month){
            if (leap(year)) {
                int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                return day[month - 1];
            } else {
                int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                return day[month - 1];
            }
        }

        public static int getTotalDay ( int year, int month){
            int totalDays = 0;
            for (int i = 1583; i < year; i++) {
                totalDays += getYearDay(i);
            }
            for (int i = 1; i < month; i++) {
                totalDays += getMonthDay(year, i);
            }
            return totalDays;
        }

    }

```

## 任务3（选做）：万年历

- [x] 代码：

```java
import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        year = sc.nextInt();

        //1583.1.1星期六
        //1900.1.1星期一


        for (int m = 0; m <= 2; m++) {
            System.out.print("一\t二\t三\t四\t五\t六\t日");
            System.out.print("\t\t\t");
            System.out.print("一\t二\t三\t四\t五\t六\t日");
            System.out.print("\t\t\t");
            System.out.print("一\t二\t三\t四\t五\t六\t日");
            System.out.print("\t\t\t");
            System.out.println("一\t二\t三\t四\t五\t六\t日");
            for (int l = 1;l<=6;l++){
                getLine(year, m*4+1, l);
                System.out.print("\t\t");
                getLine(year, m*4+2, l);
                System.out.print("\t\t");
                getLine(year, m*4+3, l);
                System.out.print("\t\t");
                getLine(year, m*4+4, l);
                System.out.println("\t\t");
            }
            System.out.println();
        }
    }


    public static void getLine(int year, int month, int line) {
        int totalDay = getTotalDay(year, month);
        int space = (totalDay + 5) % 7;
        int sum = space;
        int i = 1;
        if (line == 1) {
            for (int z = 1; z <= space; z++) {
                System.out.print("\t");
            }
            for (; i <= getMonthDay(year, month); i++) {
                System.out.print(i + "\t");
                sum++;
                if (sum % 7 == 0) {
                    break;
                }
            }
        } else {
            sum=0;
            for (i=(7-space)+7*(line-2)+1; i <=(42-space); i++) {
                if(i <= getMonthDay(year, month)) {
                    System.out.print(i + "\t");
                }else {
                    System.out.print(" " + '\t');
                }
                sum++;
                if (sum % 7 == 0) {
                    break;
                }
            }
        }
    }


    //判断闰年 是：true  否：false
    public static boolean leap ( int year){
        boolean result = false;
        if (year % 400 == 0) {
            result = true;
        } else if ((year % 100 != 0) && (year % 4 == 0)) {
            result = true;
        }
        return result;
    }

    public static int getYearDay ( int year){
        if (leap(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    public static int getMonthDay ( int year, int month){
        if (leap(year)) {
            int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return day[month - 1];
        } else {
            int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return day[month - 1];
        }
    }

    public static int getTotalDay ( int year, int month){
        int totalDays = 0;
        for (int i = 1583; i < year; i++) {
            totalDays += getYearDay(i);
        }
        for (int i = 1; i < month; i++) {
            totalDays += getMonthDay(year, i);
        }
        return totalDays;
    }

}

```

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 更深入的理解Java控制流程
  - 了解了1582年
  - 阅读了解了`java.time`包的`Instant, LocalDateTime, ZonedDateTime`等类的用法

