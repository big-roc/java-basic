package atguigu.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-25 15:10
 * 双向链表
 */
public class DoubleLinkedListTest {
    @Test
    public void test01() {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建链表
        DoubleLikedList doubleLikedList = new DoubleLikedList();

        doubleLikedList.add(hero1);
        doubleLikedList.add(hero4);
        doubleLikedList.add(hero3);
        doubleLikedList.add(hero2);

        //打印链表
        doubleLikedList.show();
    }

    @Test
    public void test02() {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建链表
        DoubleLikedList doubleLikedList = new DoubleLikedList();

        doubleLikedList.add(hero1);
        doubleLikedList.add(hero2);
        doubleLikedList.add(hero3);
        doubleLikedList.add(hero4);

        //打印链表
        doubleLikedList.show();

        doubleLikedList.delete(0);
        doubleLikedList.delete(3);
        doubleLikedList.delete(2);

        //打印链表
        doubleLikedList.show();
    }

    @Test
    public void test03() {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建链表
        DoubleLikedList doubleLikedList = new DoubleLikedList();

        doubleLikedList.add(hero1);
        doubleLikedList.add(hero2);
        doubleLikedList.add(hero3);
        doubleLikedList.add(hero4);

        //打印链表
        doubleLikedList.show();

        doubleLikedList.update(new HeroNode(2, "小卢", "玉麒麟~"));
        //打印链表
        doubleLikedList.show();
    }
}

class DoubleLikedList {
    private HeroNode2 head = new HeroNode2(-1, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //添加节点，在尾部添加
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode2);
        heroNode2.setPre(temp);
    }


    //按照no删除
    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.getNext();
        boolean flag = false;

        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
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

        HeroNode2 temp = head.getNext();
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

    //遍历打印
    public void show() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 next; //指向下一个节点
    private HeroNode2 pre; //指向上一个节点

    public HeroNode2(int no, String name, String nickName) {
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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}