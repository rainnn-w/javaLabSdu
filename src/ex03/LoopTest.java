package ex03;

public class LoopTest {
    public static void main(String[] args) {
        long s = 0;
        for(long i = 0; i <= 1000000000; ++i){ // 循环10亿次
            s += i;
        }
        System.out.printf("%d", s); // 输出应为：500000000500000000
    }
}
