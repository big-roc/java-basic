package atguigu.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author roc
 * @create 2021-02-28 19:30
 * 希尔排序
 */
public class ShellSort {
    @Test
    public void test01() {
        int[] arr = {3, 9, -1, 10, 20};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        shellSort2(arr);
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
        shellSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //0.754S
    }

    //希尔排序：交换法
    public void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    //希尔排序：移位法
    public void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
