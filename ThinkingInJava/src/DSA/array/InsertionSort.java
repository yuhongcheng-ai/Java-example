package DSA.array;

/**
 * 插入排序
 */
public class InsertionSort implements Sort{

    @Override
    public void sort(int[] array) {
        insertionSort(array,0,array.length);
    }

    /**
     * 插入排序
     */
    public void insertionSort(int[] array, int lo, int hi){
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

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        TestUtil.test(100,insertionSort);
    }
}
