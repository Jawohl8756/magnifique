package com.wunderbar.volatilee;

/**
 * @author Rommel
 * @date 2020/2/27 20:45
 * @description volatile 禁止指令重排
 */
public class ReSortSeqVolatileDemo {

    int a = 0 ;
    boolean flag =false ;

    public void methodA(){
        a =1;        //语句1
        flag =true;  //语句2
    }

    /**
     * 多线程环境中线程交替执行，由于编译器优化重排的存在
     * 两个线程中使用的变量能否保持一致性是无法确定的，结果无法预测
     *
     * 涉及到计算机底层编译原理和汇编
     *
     * 正常单线程或者顺序指令 语句1 -语句2 -语句3 ，返回值a= 6
     *
     * 如果指令重排，多线程环境下，某个线程比较快，造成了编译，读取的指令重排
     * 先 flag =true
     *   然后 a = a+5 =0+5
     *   这时候a还是初始化全局变量值0,还没读到a=1 ，
     *   总的返回值 = ！= 6
     *   数据最终不一致
     *
     * */
    public void methodB(){
        if (flag){
            a=a+5;//语句3
            System.out.println("retValue"+a);
        }
    }

}
