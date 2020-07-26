package com.wunderbar.sparsearray;

/**
 * @author Rommel
 * @date 2020/4/11 20:46
 * @description SparseArray 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.先创建一个原始的二维数组：11*11
        //0 表示没有棋子 ，1 表示黑子  2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始二维数组
        System.out.println("原始二维数组……");

        for (int[] row : chessArr1) {//二维数组，第一维的row 是第二维里面被遍历的对象
            for (int data : row) {
                System.out.printf("%d\t", data);

            }
            System.out.println();

        }

        //2.二维数组转换为稀疏数组，先遍历原始的数组
        //先遍历原始的二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {//已知11行
            for (int j = 0; j < 11; j++) {//已知11列
                if (chessArr1[i][j] != 0) {//如果某个值不为0，计数器加1
                    sum++;

                }
            }
        }
        System.out.println("sum = " + sum);//有几个非0的值

        //3.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];//下角标开始，行数=非零个数+1，列就是3（行，列，值）。
        //给稀疏数组赋值
        sparseArr[0][0] = 11;//原二维数组有11行
        sparseArr[0][1] = 11;//原二维数组有11列
        sparseArr[0][2] = sum;//原二维数组非零数据个数为sum个

        //遍历二维数组，并将非0的值存入sparseArr中
        int count = 0;//计数器,用于记录第几个非零数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;//第几行
                    sparseArr[count][1] = j;//第几列
                    sparseArr[count][2] = chessArr1[i][j];//就是那个非0值本身

                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组……");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();


        //将稀疏数组 --》 恢复成 原始的二维数组
        /*
         *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
         *	2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
