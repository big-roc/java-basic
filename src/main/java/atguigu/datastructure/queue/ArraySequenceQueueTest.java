package atguigu.datastructure.queue;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-22 14:56
 */
public class ArraySequenceQueueTest {

    @Test
    public void test03() {
        ArraySequenceQueue<String> queue = new ArraySequenceQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");

        //show()
        queue.show();
    }

    @Test
    public void test02() {
        ArraySequenceQueue<String> queue = new ArraySequenceQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        //queue.add("d");

        //poll()
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
    }

    @Test
    public void test01() {
        ArraySequenceQueue<String> queue = new ArraySequenceQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        //queue.add("d");

        //peek()
        System.out.println(queue.peek());
        //size()
        System.out.println(queue.size());
    }
}
