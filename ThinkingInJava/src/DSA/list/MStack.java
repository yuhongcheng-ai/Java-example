package DSA.list;

public class MStack<E> {

    private MArrayList mStack;

    public MStack(){
        mStack = new MArrayList();
    }

    public int size() {
        return mStack.size();
    }

    /**
     * 入栈
     */
    public void push(E e) {
        mStack.add(e);
    }

    /**
     * 出栈
     */
    public E pop(){
        return (E) mStack.remove(mStack.size()-1);
    }

    /**
     * 窥视栈顶
     */
    public E peek() {
        return (E) mStack.get(mStack.size()-1);
    }

    /**
     * 判空
     */
    public boolean isEmpty() {
        return mStack.size() == 0;
    }

    /**
     * 清空列表
     */
    public void clear() {
        mStack.clear();
    }

    public static void main(String[] args) {
        int l1[] = {1,2,3,4,5,6};
        int l2[] = {4,5,6,3,2,1};
        MStack ms1 = new MStack<Integer>();
        MStack ms2 = new MStack<Integer>();
        MStack ms3 = new MStack<Integer>();

        for(int i=l1.length-1;i>=0;i--){
            ms1.push(l1[i]);
        }
        for (int i = 0; i < l2.length;) {
            if(!ms2.isEmpty() && ms2.peek().equals(l2[i])){
                i++;
                ms3.push(ms2.pop());
            }else{
                ms2.push(ms1.pop());
            }
            if(ms1.size() == 0){
                while (ms2.size()>0) {
                    ms3.push(ms2.pop());
                    i++;
                }
            }
        }
        while (ms3.size()>0) {
            System.out.println(ms3.pop());
        }
    }
}
