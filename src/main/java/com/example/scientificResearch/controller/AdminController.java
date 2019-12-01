package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.*;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import com.example.scientificResearch.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ThesisMapper thesisMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    ApplyMapper applyMapper;

    @ResponseBody
    @GetMapping("/item/get/all")
    public ResultJson getAllItem(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                 @RequestParam(value="pageSize",required = false,defaultValue = "8") Integer pageSize){
        return  new ResultJson(true,"所有题目",itemMapper.getItemNew(currentPage,pageSize));
    }

    @ResponseBody
    @GetMapping("/thesis/get/all")
    public ResultJson getAllThesis(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                 @RequestParam(value="pageSize",required = false,defaultValue = "8") Integer pageSize){
        return  new ResultJson(true,"所有论文",thesisMapper.getAllThesis(currentPage,pageSize));
    }


    @ResponseBody
    @GetMapping("/user/get")
    public ResultJson getAllUser(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                 @RequestParam(value="pageSize",required = false,defaultValue = "8") Integer pageSize){
        return  new ResultJson(true,"所有用户",userMapper.getAllUser(currentPage,pageSize));
    }

    @ResponseBody
    @GetMapping("/user/get/count")
    public ResultJson getAllUserCount(){
        return  new ResultJson(true,"用户数目",userMapper.getAllUserCount());
    }

    @ResponseBody
    @GetMapping("/user/updata/password")
    public ResultJson updatePassword(@RequestParam String username){
        String password=  MD5Util.setEncode("123456");
        if(loginMapper.updatePassword(username,password)){
            return  new ResultJson(true,"成功",null);

        }else {
            return  new ResultJson(false,"失败",null);

        }
    }


    @ResponseBody
    @GetMapping("/user/delete")
    public ResultJson deleteUser(@RequestParam BigInteger id,@RequestParam String username){
            loginMapper.deleteUserByUsername(username);
            userMapper.deleteUserByUsername(username);
            thesisMapper.deleteThesisByAuthorId(id);
            itemMapper.deleteItemByAuthorId(id);
            applyMapper.deleteApplyByApplyId(id);
        return  new ResultJson(true,"成功",null);

    }

    @ResponseBody
    @GetMapping("/thesis/delete")
    public ResultJson deleteThesis(@RequestParam BigInteger id){
        thesisMapper.deleteThesisById(id);
        return  new ResultJson(true,"成功",null);
    }

    @ResponseBody
    @GetMapping("/item/delete")
    public ResultJson deleteItem(@RequestParam BigInteger id){
        itemMapper.deleteItemById(id);
        return  new ResultJson(true,"成功",null);
    }

    @ResponseBody
    @PostMapping("/user/updata/status")
    public ResultJson updateUserStatus(@RequestBody  User user){
        if(user==null){
            return  new ResultJson(false,"错误",null);
        }else {
            if(userMapper.updateStatusById(user)){
                return  new ResultJson(true,"成功",null);
            }else {
                return  new ResultJson(false,"更新失败",null);
            }
        }
    }

    @ResponseBody
    @PostMapping("/user/updata/type")
    public ResultJson updateUserType(@RequestBody  User user){
        if(user==null){
            return  new ResultJson(false,"错误",null);
        }else {
            if(userMapper.updateTypeById(user)){
                return  new ResultJson(true,"成功",null);
            }else {
                return  new ResultJson(false,"更新失败",null);

            }
        }
    }


}
