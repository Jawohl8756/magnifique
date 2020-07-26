package com.wunderbar.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rommel
 * @date 2020/6/20 10:26
 * @description 阶乘
 * 5! =5*4!
 * =5*4*3!
 * =5*4*3*2!
 * =5*4*3*2*1!
 * =5*4*3*2*1
 * =120
 */
@Slf4j
public class FactorialDemo {

    public static void main(String[] args) {

        log.info("5!= {}", factorialTest(5));
    }

    public static int factorialTest(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorialTest(num - 1);
        }


    }
}
