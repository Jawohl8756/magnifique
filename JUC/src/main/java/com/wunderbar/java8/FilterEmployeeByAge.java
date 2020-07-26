package com.wunderbar.java8;

/**
 * @author Rommel
 * @date 2020/3/10 12:59
 * @description 根据年龄过滤员工信息
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 30;


    }
}
