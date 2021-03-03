package leetcode.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author roc
 * @createtime 2021-02-26 16:29
 * 环形链表
 */
public class Algorithm0141 {

    //快慢指针
    public boolean hasCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //哈希表
    public boolean hasCycle01(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
