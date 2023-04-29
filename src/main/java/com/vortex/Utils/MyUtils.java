package com.vortex.Utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    //加密密码的密钥
    private final String PasswordKey = "Paradise";
    @Autowired
    private MenuMapper menuMapper;

    //加密密码
    public String encrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(PasswordKey);
        //加密信息
        String text = textEncryptor.encrypt(str);
        return text;
    }

    //解密密码
    public String decrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(PasswordKey);
        //解密信息
        String text = textEncryptor.decrypt(str);
        return text;
    }

    //格式化日期 格式:“yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒”
    public String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String now = f.format(date);
        return now;
    }

}
