package com.example.scientificResearch.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.Date;

public class Item {
    private BigInteger id;

    @NotBlank(message = "标题不能为空")
    @Length(min = 2, max = 255, message = "标题长度必须在 {min} - {max} 之间")
    private String title;

    @NotBlank(message = "内容介绍不能为空")
    @Length(min = 2, max = 999, message = "内容介绍长度必须在 {min} - {max} 之间")
    private String content;

    @NotBlank(message = "学科专业不能为空")
    @Length(min = 2, max = 50, message = "学科专业长度必须在 {min} - {max} 之间")
    private String disciplineSpecialty;
    private BigInteger authorId;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisciplineSpecialty() {
        return disciplineSpecialty;
    }

    public void setDisciplineSpecialty(String disciplineSpecialty) {
        this.disciplineSpecialty = disciplineSpecialty;
    }

    public BigInteger getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }
}
