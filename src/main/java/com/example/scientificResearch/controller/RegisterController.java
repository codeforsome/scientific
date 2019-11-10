package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.LoginMapper;
import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.Login;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import com.example.scientificResearch.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    LoginMapper loginMapper;

    @Value("${location.imgPath}")
    private String locationImgPath;

    @Value("${userHead.defaultPath}")
    private String userHeadDefaultPath;


    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/add")
    public ResultJson register(@RequestBody @Valid Login login, BindingResult bindingResult){
        if(login==null || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
            if(loginMapper.existUsername(login.getUsername())==null){
                String password=  MD5Util.setEncode(login.getPassword());
                if(loginMapper.insert(login.getUsername(),password)){
                    User user=new User();
                    user.setUsername(login.getUsername());
                    user.setNickname(login.getUsername());
                    user.setEducation("硕士");
                    user.setCollege("信息学院");
                    user.setSex("男");
                    user.setHeadIcon(userHeadDefaultPath);
                    userMapper.insert(user);
                    return new ResultJson(true,"注册成功",null);
                }else {
                    return new ResultJson(false,"注册失败，请重新注册",null);
                }
            }else {
                return new ResultJson(false,"该账号已经注册，请重新注册",null);
            }
        }
    }
}
