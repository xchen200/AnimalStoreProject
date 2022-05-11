package com.xiaoyi.models;

import com.xiaoyi.models.interfaces.Payment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String password;
    private String mobile;
    private String email;
    private Payment payment;
    private Location location;

    @Override
    public String toString() {
        return String.format("username %s, password %s, mobile %s, email %s, balance %s",
                username, password, mobile, email, payment.checkBalance());
    }

}
