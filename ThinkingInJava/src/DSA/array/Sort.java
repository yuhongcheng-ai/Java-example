package DSA.array;

import java.util.Arrays;
import java.util.Random;

public interface Sort {
    void sort(int list[]);
    void test(int n);

    default void exchange(int list[],int i,int j){
        int item = list[i];
        list[i] = list[j];
        list[j] = item;
    }

    default int[] getRandomList(int n){
        int [] array = new Random().ints(n,1,n).toArray();
        return array;
    }

    default void show(int array[]){
        System.out.println(Arrays.toString(array));
    }
}
