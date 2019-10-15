package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/update")
    public ResultJson update(@RequestBody @Valid User user, BindingResult bindingResult){
        if(user==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
           userMapper.updateUserInfoByUsername(user);
            return new ResultJson(true,"更新个人信息成功",null);
        }
    }
}
