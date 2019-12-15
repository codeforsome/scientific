package com.example.scientificResearch.model;

public class ResultJson {
    private Object data;
    private Boolean success;
    private String msg;

    public ResultJson(Boolean success, String msg,Object data) {
        this.data = data;
        this.success = success;
        this.msg = msg;
    }

    public ResultJson(Boolean success, String msg) {
        this.data = null;
        this.success = success;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
