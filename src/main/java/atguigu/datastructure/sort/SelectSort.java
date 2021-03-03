package atguigu.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author roc
 * @create 2021-02-28 15:53
 * 选择排序
 */
public class SelectSort {

    @Test
    public void test01() {
        int[] arr = {3, 9, -1, 10, 20};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
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
        selectSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //3.356S
    }

    //选择排序
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组：");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
