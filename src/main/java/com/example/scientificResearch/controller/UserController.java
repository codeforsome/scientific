package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/update")
    public ResultJson update(@RequestBody @Valid User user, BindingResult bindingResult,
                             HttpServletRequest request){
        if(user==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
            String headIconPath=(String)request.getSession().getAttribute("fileImgPath");
            String username=(String)request.getSession().getAttribute("username");
            if(headIconPath!=null){
                user.setHeadIcon(headIconPath);
            }else {
                User result =userMapper.getUserByUsername(username);
                user.setHeadIcon(result.getHeadIcon());
            }
           user.setUsername(username);
           userMapper.updateUserInfoByUsername(user);
            return new ResultJson(true,"更新个人信息成功",null);
        }
    }

    @ResponseBody
    @GetMapping("/get")
    public ResultJson getUser(HttpServletRequest request){
            String username=(String) request.getSession().getAttribute("username");
            return new ResultJson(true,"个人信息",userMapper.getUserByUsername(username));
    }

    @ResponseBody
    @GetMapping("/get/hot")
    public ResultJson getUserHot(){
        return new ResultJson(true,"热门老师",userMapper.getHotUser());
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public ResultJson getThesisByThesisId(@PathVariable BigInteger id){
        User user=userMapper.getUserById(id);
        return new ResultJson(true,"个人信息",user);
    }


}
