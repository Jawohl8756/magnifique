package com.wunderbar.javase;

/**
 * @author Rommel
 * @date 2020/3/22 13:11
 * @description 字符串类String的intern()方法
 */
public class StringInternTest {

    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}