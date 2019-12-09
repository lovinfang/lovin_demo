package com.time.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前日期的22点时间
     *
     * @param hour  小时
     * @return   时间
     */
    public static Date getTodayAccurateHourTime(int hour) {
        Calendar calendar = CalendarUtil.getCurrentCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        String curr22TimeStr = year + "/" + month + "/" + day + " " + hour + ":00:00";
        return CalendarUtil.toDate(curr22TimeStr, CalendarUtil.YYYY_MM_DD_HH24_MM_SS_SPRIT);
    }
}
