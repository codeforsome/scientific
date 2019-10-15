package com.example.scientificResearch.controller;

import com.example.scientificResearch.model.ResultJson;
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

    @ResponseBody
    @PostMapping("/add")
    public ResultJson submitResume(@RequestParam(value = "file") MultipartFile file,
                                   HttpServletRequest request){
            if (file.isEmpty()) {
                return new ResultJson(false,"文件不能为空",null);
            }
            String fileName =new Date().getTime()+"."+ file.getOriginalFilename().split("\\.")[1];
            String filePath =locationFilePath;
            File dest = new File(filePath + fileName);
            request.getSession().setAttribute("filePaht",filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
            }
            return new ResultJson(true,"文件上传成功",null);

    }
}
