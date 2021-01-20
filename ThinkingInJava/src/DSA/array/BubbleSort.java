package DSA.array;
public class BubbleSort implements Sort{
    private int exchangeNum = 0;
    private int CompareNum = 0;
    public void lowSort(int list[]) {
        int lo = 0,hi = list.length;
        while(lo < hi--){
            for(int i=0;i<hi-1;i++){
                if(list[i]>list[i+1]){
                    exchange(list,i,i+1);
                    exchangeNum++;
                }
                CompareNum++;
            }
        }
    }

    @Override
    public void sort(int list[]) {
        int lo = 0,hi = list.length;
        int n = hi;
        boolean flag = true;
        while(lo < hi&&flag){
            flag = false;
            for(int i=0;i<hi-1;i++){
                if(list[i]>list[i+1]){
                    exchange(list,i,i+1);
                    exchangeNum++;
                    n = i+1;
                    flag = true;
                }
                CompareNum++;
            }
            hi = n;
        }
    }

    public void test(int n) {
        int [] array = getRandomList(n);
        //show(array);
        long startTime = System.currentTimeMillis();
        lowSort(array);
        long endTime = System.currentTimeMillis();
        //show(array);
        System.out.println("比较次数："+CompareNum);
        System.out.println("交换次数："+exchangeNum);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        Sort test = new BubbleSort();
        test.test(100000);
    }
}
