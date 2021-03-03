package leetcode.JZ;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roc
 * @createtime 2021-03-01 15:23
 * 圆圈中最后剩下的数字
 */
public class Offer62 {

    @Test
    public void test03() {
        System.out.println(lastRemaining03(5, 3));//3
    }

    //递归
    public int lastRemaining03(int n, int m) {
        return n == 1 ? 0 : (lastRemaining03(n - 1, m) + m) % n;
    }

    @Test
    public void test02() {
        System.out.println("最终的数：" + lastRemaining02(5, 3));//[0, 1, 2, 3, 4] 3
    }

    //迭代
    public int lastRemaining02(int n, int m) {
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            idx = (idx + m) % i;
        }
        return idx;
    }

    @Test
    public void test01() {
        System.out.println("最终的数：" + lastRemaining01(5, 3));//[0, 1, 2, 3, 4] 3
    }

    //数组
    public int lastRemaining01(int n, int m) {
        List<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.toString());
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            System.out.println(arrayList.get(idx % n));
            arrayList.remove(idx);
            n--;
        }
        return arrayList.get(0);
    }
}
