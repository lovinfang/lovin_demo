/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.concurrent.threadLocal.demo1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wb-fyw404615
 * @version $Id: SafeTask.java, v 0.1 2019年03月20日 18:56 wb-fyw404615 Exp $
 */
public class SafeTask implements Runnable{

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){

        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}