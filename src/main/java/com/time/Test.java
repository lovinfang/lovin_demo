package com.time;

import com.time.util.DateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        //获取当前时间的22点时间
        Date curr22Time = DateUtil.getTodayAccurateHourTime(22);
        System.out.println(curr22Time);

        //获取当前时间
        Date currTime = new Date();

        if (currTime.before(curr22Time)){
            System.out.println("currTime before curr22Time");
        }else{
            System.out.println("curr22Time before currTime");
        }
    }
}
