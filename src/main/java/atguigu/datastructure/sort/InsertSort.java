package atguigu.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author roc
 * @create 2021-02-28 16:08
 * 插入排序
 */
public class InsertSort {
    @Test
    public void test01() {
        int[] arr = {3, 9, -1, 10, 20};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 1000000);
        }

        long startTime = System.currentTimeMillis();
        insertSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //0.754S
    }

    //插入排序
    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            //System.out.println("第" + i + "趟排序后的数组：");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
