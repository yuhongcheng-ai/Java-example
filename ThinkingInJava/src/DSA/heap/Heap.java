package DSA.heap;

public class Heap {
    private int[] arr;
    private int N;

    public Heap(int len){
        int k;
        N = 1;
        arr = new int[len + 1];
        while (N <= len){
            k = N++;
            arr[k] = (int) (Math.random() * 100);
            swim(k);
        }
    }

    public static void main(String[] args) {
        new Heap(10);
    }
    /**
     * 上浮
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k/2, k);
            k = k/2;
        }
    }

    /**
     * 下沉
     */
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i,int j){
        return arr[i] <= arr[j];
    }

    private void exchange(int i,int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
