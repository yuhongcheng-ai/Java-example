package DSA.array;

import java.util.Arrays;

public class MergeSort implements Sort{
    private int exchangeNum = 0;
    private int CompareNum = 0;
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }

    @Override
    public void test(int n) {
        int [] array = getRandomList(n);
       // show(array);
        long startTime = System.currentTimeMillis();
        sort(array);//迭代
        //merge_sort_recursive(array,new int[array.length],0,array.length-1);//递归
        long endTime = System.currentTimeMillis();
        //show(array);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = (start + end)>>1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while(start1<=end1&&start2<=end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while(start1 <= end1)
            result[k++] = arr[start1++];
        while(start2 <= end2)
            result[k++] = arr[start2++];
        for(k=start;k<=end;k++){
            arr[k] = result[k];
        }
    }

    public static void main(String[] args) {
        Sort test = new MergeSort();
        test.test(200000000);//程序运行时间：2463ms
    }
}
