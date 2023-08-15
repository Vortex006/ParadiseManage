package com.vortex.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    //格式化日期 格式:“yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒”
    public static String formatDateTimeCN(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        return f.format(date);
    }

    //格式化日期 格式:“yyyy-MM-dd HH:mm:ss”
    public static String formatDateTime(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

    //格式化日期 格式:“yyyy-MM-dd”
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(date);
    }
}
