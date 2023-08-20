package ex03;

public class Lozenge2 {
    public static void main(String[] args) {
        String n0 = args[0];
        int n=Integer.parseInt(n0);
        for(int y=1;y<=(2*n-1);y++){
            for(int x=1;x<=(2*n-1);x++){
                System.out.print(on_border(x,y,n)?args[1]:"");
            }
            System.out.print('\n');
        }

    }

    private static boolean on_border(int x, int y, int n) {
        for (int i = 0; i <= n - 1; i++) {
            if (((x == (n - i)) || x == (n + i)) && y == i + 1) {
                return true;
            } else if (((x == (i)) || x == (2 * n - i)) && y == (n - 1 + i)) {
                return true;
            }else if(x==n&&y==(2*n-1)){
                return true;
            }
        }
        return false;
    }
}
