package com.wunderbar.queue;

import java.util.Scanner;

/**
 * @author Rommel
 * @date 2020/4/11 21:45
 * @description 数组队列实例
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        //初始化一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//用户输入
        Scanner scanner = new Scanner(System.in);//接受键盘用户输入的值的扫描器
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头部数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;

                case 'a':
                    System.out.println("请输入一个数字……");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("显示的头部数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'e':

                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;


            }


        }
        System.out.println("程序退出……");
    }
}

//数组队列
class ArrayQueue {

    private int maxSize;//最大容量

    private int front;//队列头

    private int rear;//队列尾

    private int[] arr;//该数组存放数据，模拟队列

    //构造函数
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列的头部，队列的第一个数据，不包含
        rear = -1;//指向队列的尾部 ，即队列的最后一个数据，包含
    }

    //判断队列是否满如果满了，不能追加元素，只能删除
    public boolean isFull() {
        return rear == maxSize - 1;//最后一个元素（包含）等于最大容量前一个下角标的元素，那么就是满了
    }

    //判断对接是否为null
    public boolean isEmpty() {
        return rear == front;//首元素等于尾元素 .,初始化的队列为空，初始化：rear =-1 ,front =-1
    }

    //添加数据到队列
    public void addQueue(int n) {
        //先判断队列是否满，满了就不能加，直接返回
        if (isFull()) {
            System.out.println("队列已经满，不能添加元素……");
            return;
        }
        //队列不满，可以加元素，让rear后移
        rear++;
        arr[rear] = n;//参数的元素，赋给rear下角标的值
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否为空，空就不能获取元素
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取元素……");
        }

        //如果不为空，front后移
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数组
        if (isEmpty()) {
            System.out.println("队列为空，无法遍历数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }
    }

    //显示队列头部数据，不是取出数据
    public int headQueue() {
        //判空
        if (isEmpty()) {
            throw new RuntimeException("队列空，没数据");
        }
        return arr[front + 1];//为什么加1呢，队列头(不包含)的前一个位置
    }

    //显示队列尾部数据，不是取出数据
    public int rearQueue() {
        //判空
        if (isEmpty()) {
            throw new RuntimeException("队列空，没数据");
        }
        return arr[rear];//为什么不加1了，因为这里是包含关系
    }


}
