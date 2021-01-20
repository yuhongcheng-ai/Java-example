package DSA.list;

public class MQueue<E>{

    private MLinkedList<E> queue;

    public MQueue(){
        queue = new MLinkedList<E>();
    }

    public int size() {
        return queue.size;
    }

    public boolean isEmpty() {
        return queue.size == 0;
    }

    /**
     * 队列是否包含指定元素
     */
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    /**
     * 入队
     */
    public boolean add(E e) {
        return queue.add(e);
    }

    /**
     * 出队
     */
    public E poll() {
        if(queue == null || queue.size == 0){
            return null;
        }
        return queue.removeFirst();
    }

    /**
     * 获取队首元素但不出队，队空则返回空
     */
    public E peek() {
        if(queue == null || queue.size == 0){
            return null;
        }
        return queue.getFirst();
    }

    /**
     * 清空队列
     */
    public void clear() {
        queue.clear();
    }

    public static void main(String[] args) {
        MQueue m = new MQueue<String>();
        m.add(1);
        m.add(2);
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.poll());
        m.add(3);
        m.add(4);
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.contains(4));
    }
}
