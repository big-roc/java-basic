package leetcode.algorithm.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author roc
 * @createtime 2021-03-01 13:57
 * 回文链表
 */
public class Algorithm0234 {

    @Test
    public void test02() {
        ListNode listNode = ListNode.add(new int[]{1, 2, 3, 2, 1});
        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
    }

    //双指针
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        int first = 0;
        int last = arrayList.size() - 1;
        while (first < last) {
            if (!arrayList.get(first++).equals(arrayList.get(last--))) {
                return false;
            }
        }
        return true;
    }
}
