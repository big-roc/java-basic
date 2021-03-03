package leetcode.algorithm.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author roc
 * @createtime 2021-02-25 17:50
 * 删除链表的倒数第N个结点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class Algorithm0019 {
    @Test
    public void test03() {
        ListNode head5 = new ListNode(5, null);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);

        ListNode head = removeNthFromEnd03(head1, 2);
        System.out.println(head);
    }

    //双指针
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        //头指针先移动n次
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //头尾指针一起移动
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    @Test
    public void test02_1() {
        ListNode head5 = new ListNode(5, null);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);

        ListNode head = removeNthFromEnd02(head1, 2);
        System.out.println(head);
    }

    @Test
    public void test02_2() {
        ListNode head1 = new ListNode(1, null);

        ListNode head = removeNthFromEnd02(head1, 1);
        System.out.println(head);
    }

    //栈
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        assert prev != null;
        prev.next = prev.next.next;
        return dummy.next;
    }

    @Test
    public void test01() {
        ListNode head5 = new ListNode(5, null);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);

        ListNode head = removeNthFromEnd01(head1, 2);
        System.out.println(head);
    }

    //计算链表长度
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        if (n > length || n < 1) {
            throw new RuntimeException("输入的数据有误");
        }
        ListNode cur = dummy;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
