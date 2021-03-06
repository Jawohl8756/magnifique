package com.wunderbar.stack;/**
 *
 */

/**
 * @author katze
 * @date 2020/8/7 9:40
 * @description Stack栈 ，是一种FILO 先进后出的操作受限制的线性数据结构
 *
 * Ctrl+z ,浏览器的回退 ，都是使用栈的场景
 */
public class ArrayStack {
    //数组
    private String[] items;

    //栈中的元素个数
    private int count;
    //栈的大小
    private int n;

    //初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈操作
    public boolean push(String item) {
        //数组空间不够了，直接返回false,入栈失败
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    //出栈操作
    public String pop() {
        // 栈为空，则直接返回null
        if (count == 0) {
            return null;
        }

        //返回下标为count-1的数组元素，并且栈中元素个数count减一
        String tmp = items[count - 1];
        --count;
        return tmp;
    }

}
