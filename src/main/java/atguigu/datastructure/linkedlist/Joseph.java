package atguigu.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-25 16:47
 * 约瑟夫环
 */
public class Joseph {

    @Test
    public void test01() {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();

        singleCircleLinkedList.add(5);
        singleCircleLinkedList.show();

        //1,2,5: 2->4->1->5->3
        //1,3,5: 3->1->5->2->4
        singleCircleLinkedList.joseph(1, 3, 5);
    }
}

//单向环形链表
class SingleCircleLinkedList {
    private Node head = null;

    //添加n个数到环形链表中
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("num的值必须大于0");
            return;
        }
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.setNext(head);
                cur = head;
            } else {
                cur.setNext(node);
                node.setNext(head);
                cur = node;
            }
        }
    }

    /**
     * 约瑟夫问题
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void joseph(int startNo, int countNum, int nums) {
        if (head == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入：");
            return;
        }
        //head指向开始节点，cur指向最后一个节点
        Node cur = head;
        while (cur.getNext() != head) {
            cur = cur.getNext();
        }
        //小孩报数前，先让head和cur移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            head = head.getNext();
            cur = cur.getNext();
        }
        //当小孩报数时，让head和cur指针移动m-1次，然后出圈
        while (cur != head) {
            for (int i = 0; i < countNum - 1; i++) {
                head = head.getNext();
                cur = cur.getNext();
            }
            System.out.printf("小孩%d出圈\n", head.getNo());
            head = head.getNext();
            cur.setNext(head);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", head.getNo());
    }

    //遍历当前的环形链表
    public void show() {
        if (head == null) {
            System.out.println("环形链表为空");
            return;
        }

        Node cur = head;
        while (true) {
            System.out.printf("小孩的编号:%d\n", cur.getNo());
            if (cur.getNext() == head) {
                break;
            }
            cur = cur.getNext();
        }
    }
}


//节点类
class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}