package ex08;
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
