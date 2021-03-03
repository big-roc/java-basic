package atguigu.datastructure.stack;

/**
 * @author roc
 * @createtime 2021-02-25 9:35
 */
public class ArrayStack {
    private final int maxSize;
    private final int[] stack;
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int val) {
        if (this.isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = val;
    }

    //出栈
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //遍历打印
    public void show() {
        if (this.isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
