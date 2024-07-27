package DSA.array;

/**
 * 快速排序
 */
public class QuickSort implements Sort{

    private InsertionSort insertionSort = new InsertionSort();

    @Override
    public void sort(int[] arr) {
        quick_sort(arr,0, arr.length);
    }

    private void quick_sort(int[] arr,int lo, int hi) {
        if(hi <= lo + 15) {
            insertionSort.insertionSort(arr, lo, hi);
            return;
        }
        int p = partition(arr, lo, hi);
        //分别对p点前后两部分递归调用，不包括p点本身
        quick_sort(arr,lo, p);
        quick_sort(arr,p+1, hi);
    }

    /**
     * 切分方法
     */
    private int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi; //左右指针
        int mid = (lo + hi)/2;
        exchange(arr,lo,mid);
        int a = arr[lo]; // 切分元素
        while (i < j) {  //一直循环，直至i和j相遇
            while (i < j && a <= arr[--j]);//让j停在arr[j] < a的元素上
            arr[i] = arr[j];
            while (i < j && arr[++i] <= a);//让i停在a < arr[i]的元素上
            arr[j] = arr[i];
        }
        arr[i] = a;//i和j相遇时把a放在它们相遇的位置
        return i;//返回相遇的位置
    }
    
    public static void main(String[] args) {
        Sort quick = new QuickSort();
        TestUtil.test(100000,quick);
        TestUtil.test(1000000,quick);
        TestUtil.test(10000000,quick);
        TestUtil.test(100000000,quick);
    }
}
