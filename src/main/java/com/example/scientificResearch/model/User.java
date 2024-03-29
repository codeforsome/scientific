package com.example.scientificResearch.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.Date;

public class User {
    private BigInteger id;
    private String username;

    @NotBlank(message = "姓名不能为空")
    @Length(min = 1, max = 10, message = "姓名长度必须在 {min} - {max} 之间")
    private String nickname;

    @NotBlank(message = "性别不能为空")
    @Length(min = 1, max = 2, message = "长度必须在 {min} - {max} 之间")
    private String sex;

    @NotBlank(message = "学历不能为空")
    @Length(min = 1, max = 10, message = "学历长度必须在 {min} - {max} 之间")
    private String education;

    private Date createDate;

    private String headIcon;

    private String college;

    private int hot;

    private int type;

    private int status;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
