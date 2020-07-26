package com.wunderbar.cas;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicReference;


/**
 * @author Rommel
 * @date 2020/2/27 11:47
 * @description
 * CAS -> ABA -> AtomicReference
 */

public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 =new User("z3",22);
        User li4 = new User("li4",25);

        AtomicReference<User> atomicReference =new AtomicReference<User>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t current user is :"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t current user is :"+atomicReference.get().toString());

    }
}

class User{
    private String userName ;

    private int age ;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


