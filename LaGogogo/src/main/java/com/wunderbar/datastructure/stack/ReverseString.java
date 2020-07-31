package com.wunderbar.datastructure.stack;/**
 *
 */

import java.util.Stack;

/**
 * @author katze
 * @date 2020/7/28 9:56
 * @description 使用Stack栈 数据结构
 * 特点：FILO 先进后出
 * 生活中摞盘子，放在最下面的最后拿出来，最上面的最先拿出来
 * 反转字符串
 * midLength  leftLength ,rightLength ,左右互换
 * StringBuffer.reverse()
 * Collections.reverse()
 * Arrays.sort();
 * for(int i=length-1 ;1>=0;i--)
 */
public class ReverseString {
    public static void main(String[] args) {
        String sourceStr = "This is    my fucking house   ";
        System.out.println("使用Stack反转后的字符串为:" + reverseStr(sourceStr));
    }

    private static String reverseStr(String sourceStr) {
        //特殊字符串，不值得反转，直接返回
        if (sourceStr.length()<=1){
            return sourceStr;
        }

        Stack stack = new Stack();
        String tmp = "";
        for (int i = 0; i < sourceStr.length(); i++) {
            if (sourceStr.charAt(i) != ' ') {
                //单个字符之间不是空格，就放在临时变量里面
                tmp += sourceStr.charAt(i);
            } else if (tmp != "") {
                //临时变量补位null，就放在stack里面，并且清空tmp变量，continue进行下一次循环
                stack.push(tmp);
                tmp = "";

            } else {
                continue;
            }
        }
        if (tmp != "") {
            stack.push(tmp);

        }
        String result = "";
        //循环取出stack中的元素，拼接成一个长的字符串，根据stack特点，就是倒序的
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";

        }
        return result.substring(0, result.length() - 1);

    }
}
