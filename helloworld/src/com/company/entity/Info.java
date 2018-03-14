package com.company.entity;

public class Info {

    private String name;

    private String password;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Info(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Info() {
    }
}
