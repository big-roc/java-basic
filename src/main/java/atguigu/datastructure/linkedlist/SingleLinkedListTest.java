package atguigu.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-23 9:31
 * 单向链表
 */
public class SingleLinkedListTest {

    @Test
    public void test01() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //打印链表
        singleLinkedList.show();
    }

    @Test
    public void test02() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero2);

        //打印链表
        singleLinkedList.show();
    }

    @Test
    public void test03() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero2);

        //打印链表
        singleLinkedList.show();

        singleLinkedList.delete(0);
        singleLinkedList.delete(3);
        singleLinkedList.delete(2);

        //打印链表
        singleLinkedList.show();
    }

    @Test
    public void test04() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero4);
        singleLinkedList.addByNo(hero2);

        //打印链表
        singleLinkedList.show();

        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟~"));
        //打印链表
        singleLinkedList.show();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点,在尾部添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    //添加节点,按照排名
    public void addByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.getNext() == null) {
                break;
            } else if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.getNo());
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    //按照no删除
    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    //按照no修改
    public void update(HeroNode heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.getNext();
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", heroNode.getNo());
        }
    }

    //遍历打印列表
    public void show() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}