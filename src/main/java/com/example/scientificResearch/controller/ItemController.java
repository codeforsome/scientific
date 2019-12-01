package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.ApplyMapper;
import com.example.scientificResearch.mapper.ItemMapper;
import com.example.scientificResearch.model.Apply;
import com.example.scientificResearch.model.Item;
import com.example.scientificResearch.model.ResultJson;
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
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ApplyMapper applyMapper;

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
        return  new ResultJson(true,"我发布的题目",itemMapper.getItemByAuthorId(userId));
    }

    @ResponseBody
    @GetMapping("/professor/get")
    public  ResultJson getProfessItem( HttpServletRequest request){
        BigInteger userId=(BigInteger)request.getSession().getAttribute("userId");
        List<Apply> applyList=applyMapper.getItemByProfessId(userId);
        List<Item> itemList=new ArrayList<>();
        for(int i=0;i<applyList.size();i++){
            System.out.println(applyList.get(i).getItemId());
            itemList.add(itemMapper.getItemById(applyList.get(i).getItemId()));
        }
        return  new ResultJson(true,"教授管理的题目",itemList);
    }


    @ResponseBody
    @GetMapping("/delete")
    public ResultJson deleteItem(@RequestParam  BigInteger id){
        if(itemMapper.deleteItemById(id)){
            return new ResultJson(true,"成功",null);

        }else {
            return new ResultJson(false,"失败",null);

        }
    }

    @ResponseBody
    @PostMapping("/scientific/update/apply")
    public  ResultJson updateApply(@RequestBody Apply apply){
        if(applyMapper.updateApplyStatus(apply)){
            return  new ResultJson(true,"更新申请成功",null);
        }else {
            return  new ResultJson(false,"更新申请失败",null);
        }
    }

    @ResponseBody
    @PostMapping("/professor/update/check")
    public  ResultJson updateApplyCheck(@RequestBody Apply apply){

        if(applyMapper.updateProfessorCheck(apply)){
            return  new ResultJson(true,"更新申请成功",null);
        }else {
            return  new ResultJson(false,"更新申请失败",null);
        }
    }

    @ResponseBody
    @PostMapping("/scientific/update/professor")
    public  ResultJson updateProfessor(@RequestBody Apply apply){
        if(applyMapper.updateProfessor(apply)){
            return  new ResultJson(true,"更新成功",null);
        }else {
            return  new ResultJson(false,"更新失败",null);
        }
    }
    @ResponseBody
    @GetMapping("/get/userid/{id}")
    public  ResultJson getUserItem( @PathVariable BigInteger id){
        return  new ResultJson(true,"我发布的题目",itemMapper.getItemByAuthorId(id));
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public  ResultJson getItemById( @PathVariable BigInteger id){
        return  new ResultJson(true,"题目详情",itemMapper.getItemById(id));
    }


    @ResponseBody
    @GetMapping("/search")
    public ResultJson searchItem(@RequestParam String type,@RequestParam String search){
        if(type==null || search==null){
            return  new ResultJson(false,"失败",null);
        }else {

            return  new ResultJson(true,"成功",itemMapper.searchItem("%"+search+"%"));
        }
    }

    @ResponseBody
    @GetMapping("/new")
    public  ResultJson getItemNew(@RequestParam(value="currentPage",required = false,defaultValue = "0") Integer currentPage,
                                  @RequestParam(value="pageSize",required = false,defaultValue = "4") Integer pageSize ){
        return  new ResultJson(true,"题目详情",itemMapper.getItemNew(currentPage,pageSize));
    }

    @ResponseBody
    @GetMapping("/get/count")
    public ResultJson getThesisCount(){
        return new ResultJson(true,"论文总数",itemMapper.getItemsCount());
    }

    @ResponseBody
    @GetMapping("/apply/add/{id}")
    public  ResultJson addItemApply( @PathVariable BigInteger id,HttpServletRequest request){
        Apply apply=new Apply();
       apply.setItemId(id);
       String filePath=(String) request.getSession().getAttribute("filePath");
        if(filePath!=null){
            apply.setFilePath(filePath);
        }else {
            apply.setFilePath("");
        }
        apply.setApplyId( (BigInteger) request.getSession().getAttribute("userId") );
        if(applyMapper.insert(apply)){
            return  new ResultJson(true,"申请成功",null);

        }else {
            return  new ResultJson(false,"申请失败",null);
        }
    }

    @ResponseBody
    @GetMapping("/apply/get/{id}")
    public  ResultJson getItemApplyByItemId( @PathVariable BigInteger id,HttpServletRequest request){
        BigInteger userId=(BigInteger)request.getSession().getAttribute("userId");
        List<Apply> list=applyMapper.getItemApplyByItemIdAndProfeesId(id,userId);
        return  new ResultJson(true,"项目所有申请人",list);
    }

    @ResponseBody
    @GetMapping("/apply/status/get/{id}")
    public  ResultJson getItemApplyStatusByItemId( @PathVariable BigInteger id,HttpServletRequest request){
        List<Apply> list=applyMapper.getItemApplyByItemId(id);
        Boolean status=false;
        BigInteger userId=(BigInteger) request.getSession().getAttribute("userId");
        for(int i=0;i<list.size();i++){
            if(list.get(i).getApplyId().equals(userId)){
                status=true;
                break;
            }
        }
        return  new ResultJson(true,"该用户申请该科研项目的状态",status);
    }

}
