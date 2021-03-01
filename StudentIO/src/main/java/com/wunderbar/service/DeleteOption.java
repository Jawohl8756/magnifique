package com.wunderbar.service;

import com.wunderbar.domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rommel
 * @date 2021/1/30 14:00
 * @description 删除功能
 */
public class DeleteOption {

    public static void deleteById() throws IOException {
        System.out.println("请输入要删除的学生ID");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();

        BufferedReader br = new BufferedReader(new FileReader("stuInfo.txt"));
        ArrayList<Student> stuList = new ArrayList<Student>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] array = line.split(",");
            Student s = new Student();
            s.setId(array[0]);
            s.setName(array[1]);
            s.setAge(array[2]);
            s.setHobby(array[3]);
            System.out.println(s);

            stuList.add(s);

            int x;
            for (x = 0; x < stuList.size(); x++) {
                if (s.getId().equals(id)) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("stuInfo.txt"));
                    s.setDeletedFlag("1");
                    for (int i = 0; i < stuList.size(); i++) {
                        Student student = stuList.get(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(student.getId()).append(",").append(student.getName()).append(",").append(student.getAge()).append(",").append(student.getHobby());

                        bw.write(sb.toString());
                        bw.newLine();
                        bw.flush();


                    }
                    stuList.remove(x);
                    System.out.println("删除成功！");
                } else {
                    System.out.println("您输入的ID不存在，请重新输入！");
                    deleteById();
                }

            }
        }

        br.close();


    }
}
