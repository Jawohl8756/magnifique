package com.wunderbar.tool;/**
 *
 */

import java.util.Arrays;

/**
 * @author katze
 * @date 2020/8/5 10:10
 * @description Arrays工具类的copyOf方法示例
 * Arrays.copyOf(),返回一个新的数组
 * 方法传参数
 * 1.旧的数据，要被copy的数组对象
 * 2.指定新数组的长度。长度小于旧数组的长度，截取旧数组的值给新数组赋值
 *                  长达大于旧数组的长度，复制旧数组的基础上，不够的部分用0补齐
 *
 * 还是调用底层System类的native arraycopy方法
 *    参数1 ：原始数组
 *    参数2：新数组的长度
 *    public static int[] copyOf(int[] original, int newLength) {
 *         //声明一个新的数组，长度指定为参数传的新数组长度
 *         int[] copy = new int[newLength];
 *         //调用底层系统类System 的native本地方法arraycopy,有效长度，选新旧之间，更小的，无效超出部分，用0不齐
 *
 *         System.arraycopy(original, 0, copy, 0,
 *                          Math.min(original.length, newLength));
 *         return copy;
 *     }
 */
public class ArraysCopyOfDemo {

    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,5};
        int[] arr2 = Arrays.copyOf(arr1,3);//传负数那就是异常
        int[] arr3= Arrays.copyOf(arr1,10);//大于原数组的部分，用0补齐

        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\n---------------------华丽的分割线--------------------");
        for(int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
