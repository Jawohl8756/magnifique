package com.wunderbar.service;


import com.wunderbar.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rommel
 * @date 2021/1/30 14:00
 * @description 查询功能
 */
public class QueryOption {

    /**
     * 根据id查询数据
     */
    public static void SelectById() throws IOException {

        System.out.println("请输入要查询的id:");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        //把数据从txt里面取出来放入集合里面
        BufferedReader BR = new BufferedReader(new FileReader("stuInfo.txt"));
        ArrayList<Student> sm = new ArrayList<>();
        String line;
        while ((line = BR.readLine()) != null) {
            //分割字符串，放入字符数组
            String[] strArray = line.split(",");
            System.out.println("strArray="+ Arrays.asList(strArray));
            //把数据放入学生对象1
            Student s = new Student();
            s.setId(strArray[0]);
            System.out.println("取到Id了么？"+strArray[0]);
            s.setName(strArray[1]);
            s.setAge(strArray[2]);
            s.setHobby(strArray[3]);
            //把学生对象作为元素存储到集合
            sm.add(s);
        }
        //遍历集合，把输入的id和studentmodel的id对比，得到对应的student
        int i;
        for (i = 0; i < sm.size(); i++) {
            Student mod = sm.get(i);
            if (id.equals(mod.getId())) {
                System.out.println(mod.getId() + "," + mod.getAge() + "," + mod.getName() + "," + mod.getHobby());
            }
        }


    }
}
