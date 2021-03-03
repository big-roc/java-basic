package atguigu.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author roc
 * @create 2021-03-01 23:28
 * 基数排序
 */
public class RadixSort {

    @Test
    public void test01() {
        int[] arr = {53, 3, 542, 748, 14, 214};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        int digit = arrDigit(arr);
        radixSort(arr, digit);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    public void radixSort(int[] arr, int digit) {
        int[][] bucketArr = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int i = 0, n = 1; i < digit; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucketArr[digitOfElement][bucketCounts[digitOfElement]] = value;
                bucketCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucketCounts.length; k++) {
                if (bucketCounts[k] != 0) {
                    for (int m = 0; m < bucketCounts[k]; m++) {
                        arr[index++] = bucketArr[k][m];
                    }
                }
                bucketCounts[k] = 0;
            }
        }
    }

    //计算最高位
    public int arrDigit(int[] arr) {
        int max = arr[0];
        for (int data : arr) {
            if (data > max) {
                max = data;
            }
        }
        return (max + "").length();
    }
}
