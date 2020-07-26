package com.wunderbar.java8;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author Rommel
 * @date 2020/3/10 12:11
 * @description Java8 Lambda表达式测试
 */
public class LambdaTest {

    //1.原来的匿名内部类
    @Test
    public void test() {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);//方法返回时，调用的这个代码最有用

            }
        };
        //匿名内部类当参数，传给方法;
        TreeSet<Integer> treeSet = new TreeSet<Integer>(comparator);
    }


    //2.Java8 lambda表达式
    @Test
    public void test2() {

        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };

        Comparator<Integer> com1 = (x, y) ->
                Integer.compare(x, y);


        TreeSet<Integer> ts = new TreeSet<Integer>();

    }


    //造数据
    List<Employee> employees = Arrays.asList(
            new Employee("kobe", 23, 4000.0),
            new Employee("mcgrady", 34, 7000.0),

            new Employee("james", 21, 2000.0),
            new Employee("westbrooks", 45, 500.0),

            new Employee("irving", 43, 8000.0),
            new Employee("booker", 34, 900.0)

    );

    //过滤方法，过滤年龄
    public List<Employee> filterEmployees(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= 30) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //过滤方法,过滤薪水
    public List<Employee> filterEmployees1(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= 5000) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //3.需求，获取公司员工中，年龄大于35的员工信息
    @Test
    public void test3() {
        List<Employee> emps = filterEmployees(employees);
        for (Employee employee : emps) {
            System.out.println(employee);

        }
    }

    //4.需求变更，获取公司员工中，年量大于35，且工资大于5000的员工，增加过滤条件，写以往方法，就需要for循环嵌套for循环，不如直接Java8 Stream

    //优化方式1:策略设计模式，清晰分类，可能造成类膨胀
    @Test
    public void test4() {
        List<Employee> ems = filterEmployee(employees, new FilterEmployeeByAge());//传入不同的过滤策略
        for (Employee employee : ems) {
            System.out.println(employee);

        }

        System.out.println("===================");

        List<Employee> em = filterEmployee(employees, new FilterEmployeeBySalary());//传入不同的过滤策略
        for (Employee employeee : em) {
            System.out.println(employeee);
        }
    }

    public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> mp) {
        List<Employee> emp = new ArrayList<>();
        for (Employee employee : employees) {
            if (mp.test(employee)) {
                emp.add(employee);
            }
        }
        return emp;
    }

    //优化方式2，匿名内部类,方法的内部声明类的内容，较少类的数量，不会造成类膨胀
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });

        for (Employee empl : list) {
            System.out.println(empl);
        }

    }

    //优化方式3 Java8的Lambda表达式
    @Test
    public void test6() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() <= 5000);
        list.forEach(System.out::println);
    }

    //优化方式4 Java8的Stream API
    @Test
    public void test7() {
        employees.stream()
                .filter((e) -> e.getSalary() <= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("---------------------");

        employees.stream()
                .map(Employee::getAge)
                .skip(1)
                .sorted()
                .forEach(System.out::println);
    }

}
