package com.wunderbar.valuereferencetransfer;

/**
 * @author Rommel
 * @date 2020/2/29 21:19
 * @description 值传递还是引用传递
 *
 * 按照业界标注巨著 Thinking In Java
 * 老外只有值传递Value Transfer一说
 */
public class ValueTransferDemo {
    public void changeValue1(int age){
        age =30 ;

    }

    public void changeValue2(Person person){
        person.setPersonName("Guderian");
    }

    public void changeValue3(String str){
        str="xxxxxx";
    }

    public static void main(String[] args) {
        /**
         * 变量在jvm中的位置，作用域
         * 深拷贝和浅拷贝
         *
         *
         * */
        ValueTransferDemo valueTransferDemo =new ValueTransferDemo();
        /**
         * main此线程，在栈底部压入变量age=20,然后执行方法changeValue1,把继续压入变量age改成30
         * 但是最终打印的变量age还是在main主线程作用域，还是在栈底的age =20
         *
         * 基本数据类型，传递的是值         *
         * */
        int age =20 ;//基本数据类型
        valueTransferDemo.changeValue1(age);
        System.out.println("age-----"+age);

        /**
         * 引用对象类型，对象改变了属性，打印的也跟着改变
         * 对象person.personName初始值是Rommel
         * 但是changeValue2()方法，改变了属性personName值为Guderian
         * 所以最终的对象get获取的personName值也是为Guderian
         *
         * */
        Person person =new Person("Rommel");//对象：引用类型
        valueTransferDemo.changeValue2(person);
        System.out.println("personName------"+person.getPersonName());

        /**
         * 字符串引用数据类型
         * String str ="ula";
         * 声明字符串在常量池，
         * 不是new String();
         *
         * changeValue3要新建字符串，先去常量池看看，如果有，就复用
         * 如果没有，就新建字符串:xxxxx,新建了，但是没有使用
         * 还是打印作用域之前的变量值：ula
         *
         *
         * */
        String str ="ula";//字符串也是对象，也是引用类型
        valueTransferDemo.changeValue3(str);
        System.out.println("String-----"+str);
    }


}
