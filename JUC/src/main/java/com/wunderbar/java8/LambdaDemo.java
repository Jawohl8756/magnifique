package com.wunderbar.java8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author Rommel
 * @date 2020/3/10 14:34
 * @description 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符"->"，该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda表达式拆分成为两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需要执行的功能，即Lambda体
 * <p>
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x)
 * <p>
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * (Integer x, Integer y) -> Integer.compare(x, y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 可以检查是否是函数式接口
 */
public class LambdaDemo {

    @Test
    public void test1() {
        Runnable r = new Runnable() {

            int num = 100;//jdk 7和以前，需要加上final

            @Override
            public void run() {
                System.out.println("Hello Lambda!" + num);
            }
        };

        r.run();

        System.out.println("---------------------------");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();

    }

    @Test
    public void test2(){
        Consumer<String> con =(x)-> System.out.println(x);
        con.accept("I am OK with who am !");
    }
}
