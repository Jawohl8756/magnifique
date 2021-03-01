package com.wunderbar.jdk;

/**
 * @author Rommel
 * @date 2020/12/2 21:36
 * @description 变量的初始化
 */
public class VarInitialDemo {


    /**
     * 静态类级别的int类型变量a,初始化赋值和不赋值，都取得到值
     * */
    static int a ;

    public static void main(String[] args) {
        System.out.println("a = " + a);

        /**
         * 局部变量，不初始化，不能使用，会报编译错误
         * Variable 'b' might not have been initialized
         * */
        int b;
        //System.out.println("b = " + b);

    }
}
