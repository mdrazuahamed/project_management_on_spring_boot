package com.razuahamed.springboot.project_management.model;

import java.io.Serializable;

public class Task implements Serializable {
    private long id;
    private String name;
    private Member member;

    public Task(String name) {
        this.name = name;
    }

    public Task() {
        this.name = null;
        this.member = null;
        this.id = 0;
    }

    public Task(long id, String name, Member member) {
        this.name = name;
        this.member = member;
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", member=" + member +
                '}';
    }
}
