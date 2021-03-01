package com.wunderbar.main;

import com.wunderbar.domain.Student;
import com.wunderbar.service.DeleteOption;
import com.wunderbar.service.InsertOption;
import com.wunderbar.service.QueryOption;
import com.wunderbar.service.UpdateOption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rommel
 * @date 2021/1/30 12:39
 * @description 控制台入口类
 */
public class ManagerCrudEntrance {

    public static void main(String[] args) throws IOException {
        // 1.Student IO 面板
        System.out.println("1.存储学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.修改学生信息");
        System.out.println("4.查询学生信息");
        System.out.println("请输入操作功能序号:");

        // 2.接收控制台数据
        Scanner scanner = new Scanner(System.in);

        // 3.获取 功能代号
        int i = scanner.nextInt();

        switch (i) {
            case 1:
                ArrayList<Student> stuInfoList = InsertOption.saveStuInfo();
                InsertOption.writeToFile(stuInfoList);
                System.out.println("存储学生信息成功！");
                break;

            case 2:
                DeleteOption.deleteById();
                break;

            case 3:
                UpdateOption.alterById();
                break;

            case 4:
                QueryOption.SelectById();
                break;

            default:
                System.out.println("输入的功能序号有误，请重新输入...");
        }

    }
}
