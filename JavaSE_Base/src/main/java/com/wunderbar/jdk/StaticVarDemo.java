package com.wunderbar.jdk;

/**
 * @author Rommel
 * @date 2020/12/2 21:31
 * @description 静态变量
 */
public class StaticVarDemo {

    static int a = 0;

    static {
        a = 1;
        b = 2;
    }

    static int b = 0;



    public static void main(String[] args) {

        /**
         * 答案是:
         * a=1
         * b=0
         * a先初始化声明为0，但是在静态代码块重新赋值为1
         *
         * b在静态代码块声明为2 ，但是在外面又被0重新赋值覆盖了
         * */
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
