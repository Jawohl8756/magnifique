package com.wunderbar.java8;

/**
 * @author Rommel
 * @date 2020/3/10 13:01
 * @description 根据薪水过滤员工信息
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
