package DSA.list;

import java.util.*;

public class MArrayList<E> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    //用于共享的空实例
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;//不可序列化

    /**
     * ArrayList的大小（它包含的元素数）
     */
    private int size;

    /**
     * 构造函数
     * 容量 > 0，分配对应大小的空间
     * 容量 = 0，数据域等于默认共享空实例
     * 容量 < 0，抛Illegal Capacity（非法容量）异常
     */
    public MArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    /**
     * 默认构造函数
     * 构造默认容量为0的数组，在第一次添加元素时扩容
     */
    public MArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 构造函数
     * 用Collection创建初始化一个ArrayList
     */
    public MArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 将该ArrayList实例的容量修改为 列表的当前大小。
     * 此操作释放ArrayList未使用的存储空间。
     */
    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 最大的数组长度
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 增加容量以确保其至少可以容纳最小容量参数指定的元素数
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 返回此列表中的元素数
     */
    public int size() {
        return size;
    }

    /**
     * 如果列表为空，则返回true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断是否包含指定元素
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 返回指定元素在列表中首次出现的索引，未找到则返回-1
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 返回指定元素在列表中最后一次出现的索引，未找到则返回-1
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 浅复制
     * @return
     */
    public Object clone() {
        try {
            MArrayList<?> v = (MArrayList<?>) super.clone();
            v.elementData = Arrays.copyOf(elementData, size);
            //v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     * 以正确的顺序（从第一个元素到最后一个元素）返回包含此列表中所有元素的数组。
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    /**
     * 用指定元素替换此列表中指定位置的元素
     * @return 先前位于指定位置的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 检查给定的索引是否在范围内
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    /**
     * 将指定的元素追加到此列表的末尾
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);//确保容量
        elementData[size++] = e;
        return true;
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    /**
     * 清空列表
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }

    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add("1");
        list.add(null);
        list.add("2");
        list.add(null);
        MArrayList list1 = new MArrayList<String>(list);
       //int i[] = new int[MAX_ARRAY_SIZE];
       //System.out.println(list);
    }
}
