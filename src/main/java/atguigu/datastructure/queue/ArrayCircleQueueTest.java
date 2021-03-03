package atguigu.datastructure.queue;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-22 18:05
 */
public class ArrayCircleQueueTest {

    @Test
    public void test02() {
        ArrayCircleQueue<String> queue = new ArrayCircleQueue<>(4);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.poll();
        queue.add("d");
        queue.poll();
        queue.add("e");

        //poll()
        queue.show();
    }

    @Test
    public void test01() {
        ArrayCircleQueue<String> queue = new ArrayCircleQueue<>(4);
        System.out.println(queue);
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
