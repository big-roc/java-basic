package atguigu.datastructure.queue;

/**
 * @author roc
 * @createtime 2021-02-22 14:11
 * 顺序队列：先进先出，每次删除数据，全部数据前移
 */
public class ArraySequenceQueue<E> {
    private int front; //列头，只允许删除

    private int rear; //列尾，只允许插入

    private int maxSize = 16; //最大容量

    private final Object[] data;

    public ArraySequenceQueue() {
        this(10);
    }

    public ArraySequenceQueue(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("队列长度不能为负数");
        }
        front = rear = -1;
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear - front == 0;
    }

    //判断是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //入队
    public boolean add(E e) {
        if (isFull()) {
            throw new RuntimeException("队列满了");
        }
        data[++rear] = e;
        return true;
    }

    //获取列头元素，不删除该元素
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[front + 1];
    }

    //获取列头元素，并删除该元素
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        E e = (E) data[front + 1];
        for (int i = 0; i < this.size() - 1; i++) {
            data[i] = data[i + 1];
        }
        rear--;
        return e;
    }

    //队列容量
    public int size() {
        return rear - front;
    }

    //遍历队列
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            System.out.printf("arr[%s]=%s\n", i, data[i]);
        }
    }
}
