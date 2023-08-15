package com.vortex.Util;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptUtil {

    private static final String passwordKey = "Paradise";

    //加密密码
    public static String encrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(passwordKey);
        //加密信息
        String text = textEncryptor.encrypt(str);
        return text;
    }

    //解密密码
    public static String decrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(passwordKey);
        //解密信息
        String text = textEncryptor.decrypt(str);
        return text;
    }
}
