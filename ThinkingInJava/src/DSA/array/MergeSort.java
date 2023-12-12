package DSA.array;

/**
 * 归并排序
 */
public class MergeSort implements Sort{
    private int[] tem;
    @Override
    public void sort(int[] arr) {
        tem = new int[arr.length];
        merge_sort(arr,0,arr.length);
        //merge_sort(arr);
    }

    /**
     * 自顶向下的递归式归并排序
     */
    public void merge_sort(int[] arr, int lo, int hi) {
        if(hi - lo < 15){
            insertionSort(arr, lo, hi);
            return;
        }
        int mid = (lo + hi)>>1;
        merge_sort(arr, lo, mid);
        merge_sort(arr, mid, hi);
        merge(arr,lo,mid,hi);
    }

    /**
     * 插入排序
     */
    private void insertionSort(int[] array, int lo, int hi){
        int lef = lo;
        lo++;
        while(lo < hi){
            for(int i=lo;i>lef;i--){
                if(array[i] < array[i-1]){
                    exchange(array,i,i-1);
                }
            }
            lo++;
        }
    }

    /**
     * 自底向上的归并排序
     */
    public void merge_sort(int[] arr){
        int length = arr.length;
        int len = 1;//子数组的大小
        while (len < length){
            for (int lo = 0; lo < length-len; lo += 2*len) {
                merge(arr, lo, lo+len, Math.min(lo+2*len, length));
            }
            len = 2*len;
        }
    }

    /**
     * 二路归并
     */
    public void merge(int[] arr, int lo, int mid, int hi){
        if(hi - lo == 1) return;
        int k = lo;
        while (k < mid){
            tem[k] = arr[k++];//备份左子数组，右子数组在结果数组中，归并的元素先放在结果数组的左边，所以右子数组不会被覆盖
        }

        int i = lo;//左子数组的指针
        int j = mid;//右子数组的指针
        int p = lo;//结果数组的指针
        while (p < hi){//p移动到hi时说明归并完成
            if(i == mid)
                break;//左子数组元素耗完直接退出
            else if(j == hi)
                arr[p++] = tem[i++];
            else if(tem[i] <= arr[j])
                arr[p++] = tem[i++];
            else
                arr[p++] = arr[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        TestUtil.test(10000,mergeSort);
    }
}
