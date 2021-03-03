package leetcode.algorithm.linkedlist;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author roc
 * @createtime 2021-02-26 17:12
 * 相交链表
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 */
public class Algorithm0160 {

    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> listNodeSet = new HashSet<>();
        do {
            listNodeSet.add(headA);
            headA = headA.next;
        } while (headA != null);

        while (headB != null) {
            if (listNodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Deque<ListNode> stackListNode1 = stackListNode(headA);
        Deque<ListNode> stackListNode2 = stackListNode(headB);

        ListNode temp1 = stackListNode1.pop();
        ListNode temp2 = stackListNode2.pop();
        if (temp1 != temp2) {
            return null;
        } else {
            while (temp1 == temp2) {
                temp1 = stackListNode1.pop();
                temp2 = stackListNode2.pop();
            }
            return temp1.next;
        }
    }

    //把链表压入栈
    public Deque<ListNode> stackListNode(ListNode listNode) {
        ListNode dummy = new ListNode(-1, listNode);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        return stack;
    }
}










