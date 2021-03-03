package atguigu.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author roc
 * @create 2021-02-28 15:41
 * 冒泡排序
 */
public class BubbleSort {

    @Test
    public void test01() {
        int[] arr = {3, 9, -1, 10, 20};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
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
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //14.136S
    }

    //冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组：");
            //System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            }
        }
    }
}
