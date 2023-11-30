package DSA.array;

/**
 * 冒泡排序
 */
public class BubbleSort implements Sort{

    @Override
    public void sort(int[] array) {
        int lo = 0,hi = array.length;
        while(lo < hi--){
            for(int i=0; i<hi-1; i++){
                if(array[i] > array[i+1]){
                    exchange(array,i,i+1);
                }
            }
        }
    }

    public void lowSort(int[] array) {
        int lo = 0,hi = array.length;
        int n = hi;
        boolean flag = true;
        while(lo < hi && flag){
            flag = false;
            for(int i=0; i<hi-1; i++){
                if(array[i] > array[i+1]){
                    exchange(array,i,i+1);
                    n = i+1;
                    flag = true;
                }
            }
            hi = n;
        }
    }

    public static void main(String[] args) {
        Sort bubble = new BubbleSort();
        TestUtil.test(1000,bubble);
        TestUtil.test(10000,bubble);
        TestUtil.test(100000,bubble);
    }
}
