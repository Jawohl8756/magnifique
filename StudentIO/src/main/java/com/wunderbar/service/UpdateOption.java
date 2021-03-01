package com.wunderbar.service;

import com.wunderbar.domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rommel
 * @date 2021/1/30 14:00
 * @description 更新功能
 */
public class UpdateOption {

    public static void alterById() throws IOException {
        System.out.println("请输入ID");
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        BufferedReader br = new BufferedReader(new FileReader("stuInfo.txt"));

        String lines;
        ArrayList<Student> model = new ArrayList<>();
        while ((lines = br.readLine()) != null) {
            String[] arr = lines.split(",");
            Student s = new Student();
            s.setId(arr[0]);
            s.setName(arr[1]);
            s.setAge(arr[2]);
            s.setHobby(arr[3]);

            model.add(s);

        }

        //遍历
        BufferedWriter bw = new BufferedWriter(new FileWriter("stuInfo.txt"));

        int i;
        for (i = 0; i < model.size(); i++) {
            Student s = model.get(i);
            if (id.equals(s.getId())) {
                System.out.println("请输入名字");
                String name = sc.next();
                s.setName(name);

                System.out.println("请输入年龄");
                String age = sc.next();
                s.setAge(age);

                System.out.println("请输入爱好");
                String hobby = sc.next();
                s.setHobby(hobby);

                StringBuilder sb = new StringBuilder();
                sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getHobby());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();


            }


        }

        sc.close();
        bw.close();

    }
}
