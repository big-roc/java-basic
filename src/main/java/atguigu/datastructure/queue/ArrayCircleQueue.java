package atguigu.datastructure.queue;

/**
 * @author roc
 * @createtime 2021-02-22 17:05
 * 循环队列
 * <p>
 * 思路如下:
 * 1.front变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值 = 0
 * 2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置.因为希望空出一个空间做为约定.rear的初始值 = 0
 * 3.当队列满时，条件是(rear + 1) % maxSize == front 满
 * 4.对队列为空的条件，rear == front 空
 * 5.当我们这样分析，队列中有效的数据的个数(rear + maxSize - front) % maxSize
 * 6.我们就可以在原来的队列上修改得到，一个环形队列
 */
public class ArrayCircleQueue<E> {
    private int front; //列头

    private int rear; //列尾

    private int maxSize = 16; //最大容量

    private final Object[] data;

    public ArrayCircleQueue() {
        this(10);
    }

    public ArrayCircleQueue(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("队列长度不能为负数");
        }
        this.maxSize = maxSize;
        front = rear = 0;
        data = new Object[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队
    public boolean add(E e) {
        if (isFull()) {
            throw new RuntimeException("队列满了");
        }
        data[rear] = e;
        rear = (rear + 1) % maxSize;
        return true;
    }

    //获取列头元素，不删除该元素
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[front];
    }

    //获取列头元素，并删除该元素
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        E e = (E) data[front];
        front = (front + 1) % maxSize;
        return e;
    }

    //队列容量
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //遍历队列
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        //思路：从front-->rear,遍历size个
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%s]=%s\n", i % maxSize, data[i % maxSize]);
        }
    }
}
