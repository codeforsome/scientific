package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.LoginMapper;
import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.Login;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    LoginMapper loginMapper;

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
    @GetMapping("/search")
    public ResultJson searchUser(@RequestParam String type,@RequestParam String search){
        if(type==null || search==null){
            return  new ResultJson(false,"失败",null);
        }else {

            return  new ResultJson(true,"成功",userMapper.searchUser("%"+search+"%"));
        }
    }

    @ResponseBody
    @GetMapping("/get")
    public ResultJson getUser(HttpServletRequest request){
            String username=(String) request.getSession().getAttribute("username");
            return new ResultJson(true,"个人信息",userMapper.getUserByUsername(username));
    }

    @ResponseBody
    @GetMapping("/professor/get/all")
    public ResultJson getUserTypeAllProfessor(){
        List<User> loginList=userMapper.getAllUserTypeProfessor();
        List<User> userList=new ArrayList<>();
        for(int i=0;i<loginList.size();i++){
           User user=  userMapper.getUserByUsername(loginList.get(i).getUsername());
           userList.add(user);
        }
        return new ResultJson(true,"所有的专家用户",userList);
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
