package DSA.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDuplication {
    //有序数组去重
    public static void orderIntArray(int[] list){
        int i = 0;
        for (int j = 1;j<list.length;j++){
            if(list[i]<list[j]){
                list[i+1] = list[j];
                i++;
            }
        }
    }
    //无序数组去重
    public static void disorderIntArray(ArrayList<Integer> list){

    }

    public static void main(String[] args) {
        int[] list = {1,1,1,1,2,2,2,3,3,4,4,5,5,5,6,7,7,7};
        ArrayDuplication.orderIntArray(list);
        System.out.println(Arrays.toString(list));
    }
}

