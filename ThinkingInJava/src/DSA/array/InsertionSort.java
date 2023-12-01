package DSA.array;

/**
 * 插入排序
 */
public class InsertionSort implements Sort{

    @Override
    public void sort(int[] array) {
        int lo = 1,hi = array.length;
        while(lo < hi){
            for(int i=lo;i>0;i--){
                if(array[i] < array[i-1]){
                    exchange(array,i,i-1);
                }
            }
            lo++;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        TestUtil.test(10000,insertionSort);
    }
}
