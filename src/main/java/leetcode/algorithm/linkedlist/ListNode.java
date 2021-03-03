package leetcode.algorithm.linkedlist;

/**
 * @author roc
 * @createtime 2021-02-25 17:47
 * 链表结点
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode add(int[] arr) {
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;
        ListNode temp;
        for (int data : arr) {
            temp = new ListNode(data);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}
