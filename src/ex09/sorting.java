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
