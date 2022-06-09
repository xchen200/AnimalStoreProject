package com.xiaoyi.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class User {

    private Long id;

    private String username;
    private String password;
    private String age;
    private String sex;
    private String mobile;
    private String email;
    private String role;

    @Override
    public String toString() {
        return String.format("username %s, password %s, mobile %s, email %s",
                username, password, mobile, email);
    }

}
