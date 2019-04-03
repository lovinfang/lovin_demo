/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.concurrent.threadLocal.demo1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version $Id: UnsafeTask.java, v 0.1 2019年03月20日 18:40 lovin Exp $
 */
public class UnsafeTask implements Runnable {

    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate);
    }
}