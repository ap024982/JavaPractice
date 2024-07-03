package com.example.User.controller;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
    String name;
    int age;
    String city;

    public UserDetails (){}

    public UserDetails(String name, int age, String city){
       this.name=name;
       this.age=age;
       this.city=city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }




}
