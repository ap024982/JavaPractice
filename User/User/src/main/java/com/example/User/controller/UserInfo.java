package com.example.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfo {


    @Autowired
    storeUser user;

    @GetMapping("/hello/{name}")
        public String getHello(@PathVariable String name){
        return ("Hello "+name);
        }

    @GetMapping("/userInfo/{name}")
    public UserDetails getUser(@PathVariable String name) throws Exception {
        //usd = new UserDetails(new String("Atmadeep"), 40, new String ("Hyderabad"));
     //   user.addUser();

        return (user.fetchUser(name));
    }

    @PostMapping("/userInfo")
    public UserDetails getUser(@RequestBody UserDetails d) throws Exception {
        //usd = new UserDetails(new String("Atmadeep"), 40, new String ("Hyderabad"));
        return (user.addNewUser(d));

    }


}
