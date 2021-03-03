package leetcode.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author roc
 * @createtime 2021-03-01 10:30
 * 环形链表II
 */
public class Algorithm0142 {

    //哈希表
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!seen.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
