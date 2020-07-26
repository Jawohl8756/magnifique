package com.wunderbar.java8;

import lombok.*;

/**
 * @author Rommel
 * @date 2020/3/10 12:36
 * @description
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private int age;

    private double salary;
}
