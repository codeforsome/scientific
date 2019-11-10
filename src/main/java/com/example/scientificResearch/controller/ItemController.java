package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.ItemMapper;
import com.example.scientificResearch.model.Item;
import com.example.scientificResearch.model.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @ResponseBody
    @PostMapping("/add")
    public  ResultJson addItem(@RequestBody @Valid Item item, BindingResult bindingResult, HttpServletRequest request){
        if(item==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else{
            BigInteger id= (BigInteger) request.getSession().getAttribute("userId");
            item.setAuthorId(id);
            if(itemMapper.insert(item)) {
                return  new ResultJson(true,"添加成功",null);
            }else {
                return  new ResultJson(false,"添加失败",null);
            }
        }

    }

    @ResponseBody
    @PostMapping("/update")
    public  ResultJson updateItem(@RequestBody @Valid Item item, BindingResult bindingResult){
        if(item==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else{
            if(itemMapper.updateThesisByThesisId(item)) {
                return  new ResultJson(true,"更新成功",null);
            }else {
                return  new ResultJson(false,"更新失败",null);
            }
        }

    }


    @ResponseBody
    @GetMapping("/get/userid/")
    public  ResultJson getMyItem( HttpServletRequest request){
        BigInteger userId=(BigInteger)request.getSession().getAttribute("userId");
        return  new ResultJson(false,"我发布的题目",itemMapper.getItemByAuthorId(userId));
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public  ResultJson getItemById( @PathVariable BigInteger id){
        return  new ResultJson(false,"题目详情",itemMapper.getItemById(id));
    }

    @ResponseBody
    @GetMapping("/new")
    public  ResultJson getItemNew(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                  @RequestParam(value="pageSize",required = false,defaultValue = "5") Integer pageSize ){
        return  new ResultJson(false,"题目详情",itemMapper.getItemNew(currentPage,pageSize));
    }

}
