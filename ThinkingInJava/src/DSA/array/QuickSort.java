package DSA.array;

import java.util.ArrayList;
import java.util.Arrays;

//快速排序
public class QuickSort implements Sort{
    int[] arr;

    @Override
    public void sort(int[] list) {
        arr = list;
        quick_sort_recursive(0, arr.length - 1);
    }
    private void quick_sort_recursive(int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            exchange(arr,left, right);
        }
        if (arr[left] >= arr[end])
            exchange(arr,left, end);
        else
            left++;
        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }
    @Override
    public void test(int n) {
        int [] array = getRandomList(n);
        // show(array);
        long startTime = System.currentTimeMillis();
        sort(array);//迭代
        long endTime = System.currentTimeMillis();
        show(array);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        Sort test = new QuickSort();//QuickSort:2027ms  MergeSort:2463ms
        test.test(20);//22687ms
    }
}
