package com.razuahamed.springboot.project_management.model;

import java.io.Serializable;

public class Member implements Serializable {
    private long id;
    private String name;
    private int age;
    private String email;

    public Member() {
        this.name = null;
        this.age = 0;
        this.email = null;
        this.id = 0;
    }

    public Member(String name, int age, String email, int id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
