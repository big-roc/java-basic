package leetcode.algorithm.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-03-01 10:45
 * 对链表进行插入排序
 */
public class Algorithm0147 {

    @Test
    public void test02() {
        ListNode listNode = ListNode.add(new int[]{-1, 5, 3, 4, 0});

        System.out.println("排序前：");
        System.out.println(listNode.toString());

        ListNode sortListNode = sortList(listNode);
        System.out.println("排序后：");
        System.out.println(sortListNode.toString());
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode();
        ListNode tempNext;

        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            ListNode temp = listNode;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.val > cur.val) {
                    break;
                }
                temp = temp.next;
            }
            next = cur.next;
            tempNext = temp.next;
            temp.next = cur;
            cur.next = tempNext;

            cur = next;
        }
        return listNode.next;
    }
}
