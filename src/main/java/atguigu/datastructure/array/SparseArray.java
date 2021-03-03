package atguigu.datastructure.array;

import org.junit.jupiter.api.Test;

/**
 * @author roc
 * @createtime 2021-02-22 14:11
 * 二维数组和稀疏矩阵的相互转换
 */
public class SparseArray {

    @Test
    public void test() {
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子，1表示黑子 2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        System.out.println("原始二维数组");
        printArr(chessArr);

        int[][] sparseArr = planarArrayToSparseArray(chessArr);
        System.out.println("稀疏矩阵");
        printArr(sparseArr);

        int[][] planarArr = sparseArrayToPlanarArray(sparseArr);
        System.out.println("二维数组");
        printArr(planarArr);
    }

    /**
     * 稀疏数组转原始的二维数组的思路
     * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int[11][11]
     * 2.在读取稀疏数组后几行的数据，并赋给原始的二维数组即可
     */
    public int[][] sparseArrayToPlanarArray(int[][] sparseArr) {
        int row = sparseArr[0][0];
        int line = sparseArr[0][1];
        int[][] planarArr = new int[row][line];

        for (int i = 1; i < sparseArr.length; i++) {
            int rowNum = sparseArr[i][0];
            int lineNum = sparseArr[i][1];
            int value = sparseArr[i][2];
            planarArr[rowNum][lineNum] = value;
        }

        return planarArr;
    }

    //遍历打印二维数组
    public void printArr(int[][] planarArr) {
        for (int[] row : planarArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    //二维数组非0元素个数
    public int planarArraySize(int[][] planarArr) {
        int count = 0;
        for (int[] row : planarArr) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /***
     * 二维数组转稀疏数组的思路
     * 1.遍历原始的二维数组，得到有效数据的个数sum
     * 2.根据sum就可以创建稀疏数组sparseArr int[sum + 1][3]
     * 3.将二维数组的有效数据数据存入到稀疏数组
     */
    public int[][] planarArrayToSparseArray(int[][] planarArr) {
        int sum = planarArraySize(planarArr);
        int[][] sparseArr = new int[sum + 1][3];

        //稀疏数组第一行
        sparseArr[0][0] = planarArr.length;
        sparseArr[0][1] = planarArr[0].length;
        sparseArr[0][2] = sum;

        int rowNum = 1;

        for (int i = 0; i < planarArr.length; i++) {
            for (int j = 0; j < planarArr[i].length; j++) {
                if (planarArr[i][j] != 0) {
                    //临时数组
                    int[] tempArr = new int[3];

                    tempArr[0] = i;
                    tempArr[1] = j;
                    tempArr[2] = planarArr[i][j];
                    sparseArr[rowNum++] = tempArr;
                }
            }
        }
        return sparseArr;
    }
}
