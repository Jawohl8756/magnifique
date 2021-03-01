package com.wunderbar.service;

import com.wunderbar.domain.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rommel
 * @date 2021/1/30 13:17
 * @description 存储功能
 */
public class InsertOption {

    /**
     * 接收控制台信息并存储
     */
    public static ArrayList<Student> saveStuInfo() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> stuList = new ArrayList<>();
        Student student = new Student();
        System.out.println("请输入学生ID:");
        String id = scanner.next();
        student.setId(id);

        System.out.println("请输入学生姓名");
        String name = scanner.next();
        student.setName(name);

        System.out.println("请输入学生年龄");
        String age = scanner.next();
        student.setAge(age);

        System.out.println("请输入学生爱好");
        String hobby = scanner.next();
        student.setHobby(hobby);

        stuList.add(student);

        return stuList;

    }

    /**
     * 学生信息存入txt文本
     */
    public static void writeToFile(ArrayList<Student> stuList) throws IOException {

        //声明一个缓冲写对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("stuInfo.txt"));
        for (int i = 0; i < stuList.size(); i++) {
            Student stu = stuList.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getHobby());
            bw.write(sb.toString());

            //拼完一个对象，下一行
            bw.newLine();
            //刷新到缓存
            bw.flush();

        }

        //流资源一定要关闭
        bw.close();


    }

}
