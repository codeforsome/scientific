package com.example.scientificResearch.utils;

import java.io.File;

public class FileUtil {
    public static String delFile(String path) {
        String resultInfo = null;
        int lastIndexOf = path.lastIndexOf("/");
        String sb = path.substring(lastIndexOf + 1, path.length());
        sb = "f:/image/" + sb;
        File file = new File(sb);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "1-删除成功";
            } else {
                resultInfo =  "0-删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }

        return resultInfo;
    }

}
