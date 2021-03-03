package leetcode.algorithm.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-03-01 9:29
 * 反转链表
 */
public class Algorithm0206 {

    @Test
    public void test02() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.add(arr);
        ListNode reverseListNode = reverseList02(listNode);
        System.out.println(reverseListNode);
    }

    //递归
    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList02(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    @Test
    public void test01() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.add(arr);
        ListNode reverseListNode = reverseList01(listNode);
        System.out.println(reverseListNode);
    }

    //迭代
    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = new ListNode(-1);
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        return reverseHead.next;
    }
}
