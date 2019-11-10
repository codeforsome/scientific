package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.ThesisMapper;
import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.mapper.ViewMapper;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/api/thesis")
public class ThesisController {
    @Autowired
    ThesisMapper thesisMapper;

    @Autowired
    ViewMapper viewMapper;

    @Autowired
    UserMapper userMapper;


    @ResponseBody
    @PostMapping("/add")
    public ResultJson addThesis(@RequestBody @Valid Thesis thesis, BindingResult bindingResult,
                                HttpServletRequest request){
        if(thesis==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
            BigInteger id=(BigInteger)request.getSession().getAttribute("userId");
            thesis.setAuthorId(id);
            thesis.setFilePath((String) request.getSession().getAttribute("filePath"));
            if(thesisMapper.insert(thesis)){
                return new ResultJson(true,"论文添加成功",null);
            }else {
                return new ResultJson(false,"论文添加失败",null);
            }
        }
    }

    @ResponseBody
    @GetMapping("/get")
    public ResultJson getThesis(HttpServletRequest request){
        BigInteger userId=(BigInteger) request.getSession().getAttribute("userId");
        List<Thesis> thesisList= thesisMapper.getThesisByUserId(userId);
        return new ResultJson(true,"个人全部论文",thesisList);
    }

    @ResponseBody
    @GetMapping("/get/userid/{id}")
    public ResultJson getThesisByUserId(@PathVariable BigInteger id){
            List<Thesis> thesisList=thesisMapper.getThesisByUserId(id);
            return new ResultJson(true,"论文信息",thesisList);
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public ResultJson getThesisByThesisId(@PathVariable BigInteger id,
                                          HttpServletRequest request){
        Thesis thesis=thesisMapper.getThesisByThesisId(id);
        BigInteger userId=(BigInteger)request.getSession().getAttribute("userId");
        if(userId!=null){
            if(viewMapper.getViewByThesisIdAndReadUserId(id,userId)==null){
                viewMapper.insert(id,userId);
                userMapper.updateHotByUserId(thesis.getAuthorId(),userMapper.getHotByUserId(thesis.getAuthorId())+1);
                thesisMapper.updateReadNumById(id,thesis.getReadNum()+1 );
            }
        }

        return new ResultJson(true,"论文信息",thesis);
    }


    @ResponseBody
    @GetMapping("/get/hot")
    public ResultJson getThesisByThesisHot(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                           @RequestParam(value="pageSize",required = false,defaultValue = "5") Integer pageSize){
        List<Thesis> thesisList=thesisMapper.getThesisHot(currentPage,pageSize);
        return new ResultJson(true,"论文信息",thesisList);
    }

    @ResponseBody
    @GetMapping("/get/count")
    public ResultJson getThesisCount(){
        return new ResultJson(true,"论文总数",thesisMapper.getThesisCount());
    }

    @ResponseBody
    @PostMapping("/update")
    public ResultJson updateThesis(@RequestBody @Valid Thesis thesis, BindingResult bindingResult,
                              HttpServletRequest request){
        if(thesis==null  || bindingResult.hasErrors() ){
            return new ResultJson(false,bindingResult.getFieldError().getDefaultMessage(),null);
        }else {
            if(thesis.getFilePath()!=null){
                thesis.setFilePath((String) request.getSession().getAttribute("filePath"));
            }
            if(thesisMapper.updateThesisByThesisId(thesis)){
                return new ResultJson(true,"论文更新成功",null);
            }else {
                return new ResultJson(false,"论文更新失败",null);
            }
        }
    }
}
