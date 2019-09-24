package com.qfedu.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    /**
     * 日期计算工具，根据参数向前或向后推算日期，并将结果转为String格式
     *
     * @param date   一个date类型的参数，需要进行推算的日期
     * @param amount 一个int类型的参数，表示向前或向后推算若干天，正数表示向前推算，负数表示向后推算，0表示当前
     * @return 将计算的结果转换成String格式并返回
     */
    public static String dateStr(Date date, int amount) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, amount);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }
}
