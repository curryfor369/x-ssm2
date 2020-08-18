package com.xing.pojo;

public class User {
    private int id;
    private String name;
    private int age2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public User(int id, String name, int age2) {
        this.id = id;
        this.name = name;
        this.age2 = age2;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age2=" + age2 +
                '}';
    }
}
