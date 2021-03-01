package com.wunderbar.domain;

/**
 * @author Rommel
 * @date 2021/1/30 12:41
 * @description 学生实体类
 */
public class Student {

    // id
    private String id;
    // 姓名
    private String name;
    // 年龄
    private String age;
    // 爱好
    private String hobby;
    // 是否已经删除 o: 否 1：是
    private String deletedFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", deletedFlag='" + deletedFlag + '\'' +
                '}';
    }
}
