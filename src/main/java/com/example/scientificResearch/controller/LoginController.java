package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.LoginMapper;
import com.example.scientificResearch.model.Login;
import com.example.scientificResearch.model.ResultJson;
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

@Controller
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    LoginMapper loginMapper;

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
                    request.getSession().setAttribute("username",result.getUsername());
                    request.getSession().setAttribute("userType",result.getType());
                    String userToken=   MD5Util.setEncode(result.getUsername()+PWS);
                    return new ResultJson(true,"登陆成功",userToken);
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
