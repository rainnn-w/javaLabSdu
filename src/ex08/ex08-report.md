# Java程序设计-实验报告-08：动态数组

## 任务0：

- 简述关键字用途：
  - [x] `assert `判断一个表达式
  - [x] `catch `用在异常处理中，用来捕捉异常
  - [x] `finally` 用在异常中最后一定执行的语句
  - [x] `throw` 抛出一个异常
  - [x] `throws `声明在当前定义的成员方法中所有需要抛出的异常
  - [x] `try `尝试一个可能抛出异常的程序块

## 任务1：动态数组功能实现

- [x] 代码：

```java
public class ArrayList {
    private Object[] arrayList;
    private int count;
    public ArrayList(){
        count=0;
        arrayList=new Object[4];
    }

    public void reflexive(){
        ArrayList result;
        Object[] temp=new Object[arrayList.length];
        if(!(count==0||count==1)){
            if(count%2==0){
                for(int i=0;i<=count-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
            }else{
                for(int i=0;i<=(count/2)-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
                temp[count/2]=arrayList[count/2];
                for(int i=(count/2)+1;i<=count-1;i++){
                    temp[i]=arrayList[count-1-i];
                }
            }
        }
        arrayList=temp;
    }

    public void swap(ArrayList list){
        Object[] a=new Object[arrayList.length];
        ArrayList b=new ArrayList();
        for(int i=0;i<arrayList.length;i++){
            a[i]=arrayList[i];
        }
        for(int i=0;i<list.getLength();i++){
            b.set(i,list.get(i));
        }
        arrayList=a;
        list=b;
    }

    public void set(int idx,Object obj){
        arrayList[idx]=obj;
    }

    public boolean equals(ArrayList list){
        if(arrayList.length!=list.getLength()){
            return false;
        }
        if(count!= list.getCount()){
            return false;
        }
        for(int i=0;i<=count-1;i++){
            if(arrayList[i]!=list.get(i)){
                return false;
            }
        }
        return true;
    }

    public int getLength(){
        return arrayList.length;
    }
    public int getCount(){
        return count;
    }
    public boolean checkIndex(int idx){
        if(idx<0||idx>=arrayList.length) {
            return false;
        }else{
            return true;
        }
    }

    public Object get(int idx){
        if(idx<0||idx>=arrayList.length){
            return false;
        }else{
            return arrayList[idx];
        }
    }

    public void delete(int idx){
        Object[] temp=new Object[arrayList.length-1];
        for(int i=0;i<idx;i++){
            temp[i]=arrayList[i];
        }
        for(int i=idx;i<arrayList.length;i++){
            temp[i]=arrayList[i+1];
        }
        arrayList=temp;
        count--;
    }

    public void append(Object obj){
        if(count==arrayList.length){
            increaseSize();
        }
        arrayList[count]=obj;
        count++;
    }

    public void update(Object obj,int idx){
        arrayList[idx]=obj;
    }

    public void swapPosition(int idx,int idx2){
        Object a=arrayList[idx];
        arrayList[idx]=arrayList[idx2];
        arrayList[idx2]=a;
    }

    public void insert(Object obj,int idx){
        if(count==arrayList.length){
            increaseSize();
        }
        Object[] temp=new Object[arrayList.length+1];
        for(int i=0;i<idx;i++){
            temp[i]=arrayList[i];
        }
        temp[idx]=obj;
        for(int i=idx+1;i<=count;i++){
            temp[i+1]=arrayList[i];
        }
        arrayList=temp;
        count++;
    }

    public void increaseSize(){
        Object[] temp=new Object[arrayList.length*2];
        for(int i=0;i<arrayList.length;i++){
            temp[i]=arrayList[i];
        }
        arrayList=temp;
    }

}

```

## 任务2：性能测试

- [x] 问题：请描述并分析性能测试结果，与Java内置的`ArrayList<T>`进行对比。

```java
public class Stopwatch {
    public static void main(String[] args) {
        ArrayList watch = new ArrayList();
        for (int r = 1; r <= 50; r++) {
            long startTime = System.currentTimeMillis();
            for (int i = 1; i <= 10000; i++) {
                watch.append(Math.random() * 100);
                watch.insert(Math.random() * 100, 0);
                watch.insert(Math.random() * 100, (int) (Math.random() * 4));
            }
            long endTime = System.currentTimeMillis();
            long usedTime = (endTime - startTime);//ms
            System.out.println(usedTime);
        }
    }
}

//时间逐渐增长
/*
824
2710
4701
6829
11171
14285
17228
19284
22189
24789
26899
29114
32229
33354
36317
 */

```

```java
import java.util.ArrayList;
public class Stopwatch0 {
    public static void main(String[] args) {
        ArrayList<Object> watch=new ArrayList<Object>();
        for (int r = 1; r <= 50; r++) {
            long startTime = System.currentTimeMillis();
            for (int i = 1; i <= 10000; i++) {
                watch.add(Math.random() * 100);
                watch.add(0, Math.random() * 100);
                watch.add( (int) (Math.random() * 4),(Math.random() * 100));
            }
            long endTime = System.currentTimeMillis();
            long usedTime = (endTime - startTime);//ms
            System.out.println(usedTime);
        }
    }
}

//快太多了！
/*
46
127
232
292
398
500
503
630
855
755
889
951
1180
1160
1299
1311
1479
1475
1721
1804
1940
1902
1890
2320
2420
 */

```

```java
public class test {
    public  static void main(String[] args){
        ArrayList list=new ArrayList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.reflexive();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }
}
```

## 任务3：功能扩展（选做）

- [x] 模板化（参数类型）
- [x] 实现`swap()`方法
- [x] 实现`boolean equals(ArrayList lst)`方法，注意自反、对称、传递，`null`的处理。
- [x] 实现`int hashCode()`方法。讨论`equals`与`hashCode`的关系。

> 方法均已实现，在任务一的代码中

1、如果两个对象equals相等，那么这两个对象的HashCode一定也相同

2、如果两个对象的HashCode相同，不代表两个对象就相同，只能说明这两个对象在散列存储结构中，存放于同一个位置

## 思考

- [x] 当用户指定初始容量时，是精确设定还是扩充到最近的2的倍数？

  扩充到最近的2倍数吧 与之后再新建数组来扩展空间相比更节省空间

## 实验总结

- [x] 请简述实验的心得体会。欢迎对实验形式、内容提出意见和建议。
  - 深入理解使用数组
  - 通过自己创建ArrgtList类更深入了解了java的ArrayList类
  - 学习了equal和hashcode方法的区别等
