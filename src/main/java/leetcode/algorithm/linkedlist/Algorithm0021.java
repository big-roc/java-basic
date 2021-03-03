package leetcode.algorithm.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-26 13:55
 * 合并两个有序链表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class Algorithm0021 {
    @Test
    public void test02() {
        ListNode l1 = ListNode.add(new int[]{1, 2, 4});
        ListNode l2 = ListNode.add(new int[]{1, 3, 4});

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        ListNode mergeListNode = mergeTwoLists02(l1, l2);
        System.out.println(mergeListNode);
    }

    //递归
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists02(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists02(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test01() {
        ListNode l1 = ListNode.add(new int[]{1, 2, 4});
        ListNode l2 = ListNode.add(new int[]{1, 3, 4});

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        ListNode mergeListNode = mergeTwoLists01(l1, l2);
        System.out.println(mergeListNode);
    }

    //迭代
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //合并后l1和l2最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
