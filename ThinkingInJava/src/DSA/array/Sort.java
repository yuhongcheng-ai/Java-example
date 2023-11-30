package DSA.array;

public interface Sort {

    void sort(int[] array);

    default void exchange(int[] array, int i, int j){
        int item = array[i];
        array[i] = array[j];
        array[j] = item;
    }
}
