package com.shunwang.mylibrary;

import android.text.TextUtils;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * app中文字显示格式
 * Created by sb.wang on 2016/4/15.
 */
public class FormatUtil {
    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTES = 60;// 分钟

    /**
     * 格式化app大小的显示
     *
     * @param bytes
     * @return
     */
    public static String formatSize(long bytes) {
        String str;
        if (bytes < 1024) {
            str = bytes + "B";
        } else if (bytes < 1024 * 1024) {
            str = formatDecimal(1, (bytes * 1.0 / 1024)) + "KB";
        } else if (bytes < 1024 * 1024 * 1024) {
            str = formatDecimal(1, (bytes * 1.0 / 1024 / 1024)) + "MB";
        } else
            str = formatDecimal(1, (bytes * 1.0 / 1024 / 1024 / 1024)) + "GB";
        return str;
    }

    /**
     * 格式化app下载数的显示
     *
     * @param count
     * @return
     */
    public static String formatDownNum(int count) {
        String str = "" + count;
        if (count > 10000) {
            str = "" + formatDecimal(1, (count * 1.0) / 10000) + "万";
        }
        return str;
    }

    /**
     * 格式化app更新时间的显示
     *
     * @param times
     * @return
     */
    public static String[] formatUpdateTimeArray(long times) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - times) / 1000;// 与现在时间相差秒数
        String[] str = new String[2];

        if (timeGap > MONTH * 6) {
            str[0] = "6";
            str[1] = "个月前";
        } else if (timeGap > MONTH) {
            str[0] = "" + timeGap / MONTH;
            str[1] = "个月前";
        } else if (timeGap > DAY) {
            str[0] = "" + timeGap / DAY;
            str[1] = " 天 ";
        } else if (timeGap > HOUR) {
            str[0] = "" + timeGap / HOUR;
            str[1] = " 小时前 ";
        } else if (timeGap > MINUTES) {
            str[0] = "" + timeGap / MINUTES;
            str[1] = " 分钟前 ";
        } else {
            str[0] = "";
            str[1] = " 刚刚 ";
        }
        return str;
    }

    /**
     * 保留小数点个数
     *
     * @param count
     * @return
     */
    public static String formatDecimal(int count, double value) {
        if ((int) value == value) return (int) value + "";
        String decimal = "0.";
        for (int i = 0; i < count; i++) {
            decimal += "0";
        }
        DecimalFormat df = new DecimalFormat(decimal);
        return df.format(value);
    }


    public static String getCurren(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            return "";
        }

        String[] formatStr = formatUpdateTimeArray(date.getTime());
        return formatStr[0] + formatStr[1];
    }

    public static String initPhoneNum(String pNumber){
        if(!TextUtils.isEmpty(pNumber) && pNumber.length() > 6 ){
            StringBuilder sb  =new StringBuilder();
            for (int i = 0; i < pNumber.length(); i++) {
                char c = pNumber.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }else {
            return "";
        }
    }


    public static boolean checkPwd(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) { //循环遍历字符串
            if (Character.isDigit(str.charAt(i))) {     //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            }
            if (Character.isLetter(str.charAt(i))) {   //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        boolean length = str.length() > 5 && str.length() <26;

        return length && isDigit && isLetter;
    }

}
