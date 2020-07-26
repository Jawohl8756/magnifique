package com.wunderbar.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rommel
 * @date 2020/7/18 21:07
 * @description 用户实体类
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User implements Comparable {

    private String name;

    private int age;

    /**
     * 根据年龄age
     *       升序ASC
     *       降序DESC：  -(this.age+"").compareTo(user.age+"");
     *
     * */
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            //int 类型的元素转成String,因为compareTo()方法的参数数String类型
            return (this.age+"").compareTo(user.age+"");

        } else {
            new RuntimeException("输入的类型不匹配，不能转换，无法比较");
        }

        return 0;

    }


    /**
     * 按照姓名name
     *       从小到大 ASC
     *       从大到小DESC :return -this.name.compareTo(user.name);
     */
   /* public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            return this.name.compareTo(user.name);

        } else {
            new RuntimeException("输入的类型不匹配，不能转换，无法比较");
        }

        return 0;
    }*/


    }

