package ex08;

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
