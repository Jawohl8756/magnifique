package com.wunderbar.oom;

/**
 * @author Rommel
 * @date 2020/3/21 21:02
 * @description 栈溢出异常演示
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }


    //循环调用自己，递归无出口，栈对应一个方法，栈分配不过来，就溢出了
    private static void stackOverflowError() {
        stackOverflowError();
    }
}
