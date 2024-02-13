package com.razuahamed.springboot.project_management.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private long id;
    private String name;
    private List<Task> taskList;

    public Team() {
        this.name = "No name";
        this.taskList = null;
        this.id = 0;
    }

    public Team(long id, String name, List<Task> taskList) {
        this.name = name;
        this.taskList = taskList;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
