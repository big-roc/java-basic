package atguigu.datastructure.stack;

import java.util.Scanner;

/**
 * @author roc
 * @createtime 2021-02-25 9:48
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key;
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("s(show): 表示显示栈");
            System.out.println("e(exit): 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择:");
            key = scanner.next();
            switch (key) {
                case "s":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数:");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        System.out.printf("出栈的数据是:%d\n", stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}
