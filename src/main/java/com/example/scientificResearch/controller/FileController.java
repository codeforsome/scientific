package com.example.scientificResearch.controller;

import com.example.scientificResearch.mapper.UserMapper;
import com.example.scientificResearch.model.ResultJson;
import com.example.scientificResearch.model.User;
import com.example.scientificResearch.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/api/file")
public class FileController {

    @Value("${location.filePath}")
    private String locationFilePath;

    @Value("${location.imgPath}")
    private String locationImgPath;

    @Value("${userHead.defaultPath}")
    private String userHeadDefaultPath;

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/add")
    public ResultJson addFile(@RequestParam(value = "file") MultipartFile file,
                                   HttpServletRequest request){
            if (file.isEmpty()) {
                return new ResultJson(false,"文件不能为空",null);
            }
            String fileName =new Date().getTime()+"."+ file.getOriginalFilename().split("\\.")[1];
            String filePath =locationFilePath;
            File dest = new File(filePath + fileName);
            request.getSession().setAttribute("filePath","/public/thesis/" + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
            }
            return new ResultJson(true,"文件上传成功",null);

    }

    @ResponseBody
    @PostMapping("/img/add")
    public ResultJson addImg(@RequestParam(value = "file") MultipartFile file,
                                   HttpServletRequest request){
        if (file.isEmpty()) {
            return new ResultJson(false,"图片不能为空",null);
        }
        String fileType= file.getOriginalFilename().split("\\.")[1];
        if(fileType.equals("jpg")||fileType.equals("jpeg")||fileType.equals("png")){
            String fileName =new Date().getTime()+"."+ fileType;
            String filePath =locationImgPath;
            File dest = new File(filePath + fileName);
            request.getSession().setAttribute("fileImgPath","/public/img/" + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
            }
            return new ResultJson(true,"图片上传成功",null);
        }else {
            return new ResultJson(false,"请上传图片格式为jpg,jpeg,png类型",null);
        }

    }
}
