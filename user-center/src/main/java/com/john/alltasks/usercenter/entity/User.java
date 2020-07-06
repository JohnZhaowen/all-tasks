package com.john.alltasks.usercenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String Id;
    String username;
    String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}