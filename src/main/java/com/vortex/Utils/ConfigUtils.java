package com.vortex.Utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ConfigUtils {

    private String pathname = "E:\\IDEA\\ParadiseManage\\src\\main\\resources\\Notice.properties";

    //向config文件中写入
    public void setConfig(String key, String value, String comments) {
        File file = new File(pathname);
        Properties ps = new Properties();
        try {
            InputStream inputStream = new FileInputStream(file);
            ps.load(inputStream);
            ps.setProperty(key, value);
            OutputStream outputStream = new FileOutputStream(file);
            ps.store(outputStream, comments);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取config文件的内容
    public String getConfig(String key) {
        String value = null;
        File file = new File(pathname);
        Properties ps = new Properties();
        try {
            InputStream inputStream = new FileInputStream(file);
            ps.load(inputStream);
            value = ps.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    //获取格式化的日期注释
    public String getDefaultComments() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
        String now = f.format(date);
        return now;
    }
}
