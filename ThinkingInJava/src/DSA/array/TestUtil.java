package DSA.array;

import java.util.Arrays;
import java.util.Random;

public class TestUtil {
    /**
     * 返回一个大小为n的，由1到n之间的随机整数组成的数组
     */
    public static int[] getRandomArray(int n){
        return new Random().ints(n,1,n).toArray();
    }

    public void show(int array[]){
        System.out.println(Arrays.toString(array));
    }

    public static void test(int n,Sort sort) {
        int [] array = getRandomArray(n);
        //show(array);
        long startTime = System.currentTimeMillis();
        sort.sort(array);
        long endTime = System.currentTimeMillis();
        //show(array);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
