package com.yxb.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/6 22:13
 */
public class DateUtils {

    public static String format(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
