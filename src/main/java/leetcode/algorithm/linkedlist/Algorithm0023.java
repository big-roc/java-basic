package leetcode.algorithm.linkedlist;

/**
 * @author roc
 * @createtime 2021-03-01 14:23
 * 合并K个升序链表
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 */
public class Algorithm0023 {

    //顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode dummy = null;
        for (ListNode listNode : lists) {
            dummy = mergeTwoLists(dummy, listNode);
        }
        return dummy;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
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
