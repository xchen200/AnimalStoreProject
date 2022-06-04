package com.xiaoyi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private String age;
    private String sex;
    private String mobile;
    private String email;
    private String role;

    @Override
    public String toString() {
        return String.format("username %s, password %s, mobile %s, email %s",
                name, password, mobile, email);
    }

}
