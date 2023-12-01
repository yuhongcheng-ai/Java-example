package DSA.array;
/**
 * 选择排序
 */
public class SelectionSort implements Sort{

    @Override
    public void sort(int[] array) {
        int lo = 0,hi = array.length,min;
        while(lo < hi){
            min = lo;
            for(int i=lo; i<hi-1; i++){
                if(array[min] > array[i+1]){
                    min = i+1;
                }
            }
            exchange(array,min,lo);
            lo++;
        }
    }

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        TestUtil.test(1000,selection);
    }
}
