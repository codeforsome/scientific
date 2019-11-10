package com.example.scientificResearch.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.Date;

public class Thesis {
    private BigInteger id;

    @NotBlank(message = "论文名称不能为空")
    @Length(min = 2, max = 36, message = "论文名称长度必须在 {min} - {max} 之间")
    private String title;

    @NotBlank(message = "摘要不能为空")
    @Length(min = 1, max = 1000, message = "摘要长度必须在 {min} - {max} 之间")
    private String abstracts;

    private BigInteger authorId;

    private Date date;

    @NotBlank(message = "关键词不能为空")
    @Length(min = 1, max = 60, message = "关键词长度必须在 {min} - {max} 之间")
    private String keyword;
    private String filePath;

    @NotBlank(message = "学科专业不能为空")
    @Length(min = 1, max = 60, message = "学科专业长度必须在 {min} - {max} 之间")
    private String disciplineSpecialty;

    private int collectNum;
    private int readNum;

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public BigInteger getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDisciplineSpecialty() {
        return disciplineSpecialty;
    }

    public void setDisciplineSpecialty(String disciplineSpecialty) {
        this.disciplineSpecialty = disciplineSpecialty;
    }
}
