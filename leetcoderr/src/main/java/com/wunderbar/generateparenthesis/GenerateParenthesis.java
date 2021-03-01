package com.wunderbar.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rommel
 * @date 2020/9/19 17:14
 * @description 生成有效括号组合
 * 力扣22题
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> validParenthesis=generateParenthesis(5);
        System.out.println("validParenthesis = " + validParenthesis);
    }

    /**
     * @param n n对括号
     * @return result 符合条件的List
     */
    public static
    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateOneByOne("", result, n, n);

        return result;
    }

    /**
     * @param subList
     * @param result
     * @param left    n对括号，left表示左括号剩余数量
     * @param right   n对括号，right表示右括号剩余数量
     */
    public static void generateOneByOne(String subList, List<String> result, int left, int right) {

        //参数判断
        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }
        if (left > 0) {
            generateOneByOne(subList + "(", result, left - 1, right);
        }

        if (right > left) {
            generateOneByOne(subList + ")", result, left, right - 1);

        }


    }

}

