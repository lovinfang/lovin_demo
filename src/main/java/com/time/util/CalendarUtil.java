package com.time.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class CalendarUtil {

    /**
     * yyyy/MM/dd HH24:mm:ss 斜杠日期 24小时制格式
     */
    public static final String YYYY_MM_DD_HH24_MM_SS_SPRIT = "yyyy/MM/dd HH:mm:ss";

    /**
     * 获取当前的日历
     *
     * @return
     */
    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 将日期字符串转换为{@link java.util.Date}
     *
     * @param dateStr
     * @param datePattern 格式
     * @return
     */
    public static Date toDate(String dateStr, String datePattern) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(datePattern)) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }
}
