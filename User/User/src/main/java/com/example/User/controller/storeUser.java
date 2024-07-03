package com.example.User.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class storeUser {
    List<UserDetails> arr =new ArrayList<>(5);
    public storeUser(){
        arr.add(new UserDetails("Atmadeep",43,"Hyderabad"));
        arr.add(new UserDetails ("Avyukt",10,"Hyderabad"));
        arr.add(new UserDetails ("Avyaan",3,"Hyderabad"));
        arr.add(new UserDetails ("Priyanka",33,"Bangalore"));
        arr.add(new UserDetails ("Usha",36,"Mumbai"));
    }


    public UserDetails fetchUser(String strName) throws Exception {
      //  int iFlag=0;
        UserDetails u1=null;
        for(UserDetails u : arr){
            if(u.getName().compareToIgnoreCase(strName)==0){
                u1=u;
                break;
            }
        }
        if (u1==null ) {
            CustomException c= new CustomException(String.format("User %s Not Found",strName));
            c.userException();
        }
        return u1;
    }

    public UserDetails addNewUser(UserDetails u) throws Exception {
        UserDetails u1=null;
        for(UserDetails u2 : arr){
            if(u2.getName().compareToIgnoreCase(u.getName())==0){
                u1=u;
                CustomException c= new CustomException(String.format("User %s already exists",u.getName()));
                c.userException();
                break;
            }
        }
        if (u1==null) {
          arr.add(u);
        }
        return u;

    }


}
