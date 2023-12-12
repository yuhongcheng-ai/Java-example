package DSA.array;
/**
 * 希尔排序
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] array) {
        int h = 1;
        while (h < array.length / 3) h = 3 * h + 1;//获得一个不大于array.length增量
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                // 将array[i]插入到array[i-h], array[i-2*h], array[i-3*h]... 之中
                for (int j = i; j >= h; j = j-h) {
                    if (array[j] < array[j - h]) {
                        exchange(array, j, j - h);
                    }
                }
            }
            h = h / 3;//每次增减变为原来的三分之一
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        TestUtil.test(1000, shellSort);
        TestUtil.test(10000, shellSort);
        TestUtil.test(100000, shellSort);
        TestUtil.test(1000000, shellSort);
    }
}

