package custom.Demo3;

import java.util.Arrays;
/*
 *动态规划 斐波那契
 */
public class Fibonacci {
    private int fibonacci[];
    public int fibonacci(int n){
        int n1 = 0;
        int n2 = 1;
        int m = 0;
        this.fibonacci = new int[n];
        this.fibonacci[1] = n2;
        for(int i=2;i<n;i++){
           m = n2;
           n2 = n2 + n1;
           n1 = m;
            this.fibonacci[i] = n2;
        }
        System.out.println(Arrays.toString(this.fibonacci));
        return n2;
    }
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacci(30));
    }
}
