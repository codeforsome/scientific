package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.LoginMapper;
import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.Login;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import com.example.scientificResearch.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    UserMapper userMapper;

    private final  String PWS="huangmanjin";

    @ResponseBody
    @PostMapping("/verify")
    public ResultJson register(@RequestBody @Valid Login login, BindingResult bindingResult, HttpServletRequest request){
        if(login==null || bindingResult==null || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
                String password=  MD5Util.setEncode(login.getPassword());
                Login   result=loginMapper.existLoginInfo(login.getUsername(),password);
                if(result!=null){
                    User user=userMapper.getUserByUsername(result.getUsername());
                    if(user.getStatus()==0){
                        return new ResultJson(false,"该用户被禁止登陆，请找管理员！",null);
                    }
                    request.getSession().setAttribute("username",result.getUsername());
                    request.getSession().setAttribute("userType",user.getType());
                    request.getSession().setAttribute("userId",user.getId());
                    String userToken=   MD5Util.setEncode(result.getUsername()+PWS);
                    Map map=new HashMap();
                    map.put("userToken",userToken);
                    map.put("userType",user.getType());
                    map.put("user",userMapper.getUserByUsername(result.getUsername()));
                    return new ResultJson(true,"登陆成功",map);
                }else {
                    return new ResultJson(false,"账号或者密码错误",null);
                }
        }
    }

    @RequestMapping("/out")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
