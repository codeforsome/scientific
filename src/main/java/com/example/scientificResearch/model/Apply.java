package com.example.scientificResearch.model;

import java.math.BigInteger;
import java.util.Date;

public class Apply {
    private BigInteger id;
    private BigInteger applyId;
    private BigInteger professorId;
    private Date professorDate;
    private Date applyDate;
    private Date checkDate;
    private  BigInteger itemId;
    private  int apply;
    private String filePath;
    private Date date;
    private int checkStatus;

    public Date getProfessorDate() {
        return professorDate;
    }

    public void setProfessorDate(Date professorDate) {
        this.professorDate = professorDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getApplyId() {
        return applyId;
    }

    public void setApplyId(BigInteger applyId) {
        this.applyId = applyId;
    }

    public BigInteger getProfessorId() {
        return professorId;
    }

    public void setProfessorId(BigInteger professorId) {
        this.professorId = professorId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public int getApply() {
        return apply;
    }

    public void setApply(int apply) {
        this.apply = apply;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
