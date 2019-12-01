package com.example.scientificResearch.model;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;


public class Login {

    private BigInteger id;

    @NotBlank(message = "账号不能为空")
    @Length(min = 3, max = 10, message = "账号长度必须在 {min} - {max} 之间")
    private String username;

    @NotBlank (message = "密码不能为空")
    @Length(min = 3, max = 10, message = "密码长度必须在 {min} - {max} 之间")
    private String password;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
