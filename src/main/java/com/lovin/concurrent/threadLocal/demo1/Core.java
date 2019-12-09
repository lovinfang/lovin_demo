/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.concurrent.threadLocal.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @version $Id: Core.java, v 0.1 2019年03月20日 18:42 lovin Exp $
 */
public class Core {

    public static void main(String[] args) {
        //UnsafeTask task = new UnsafeTask();
        SafeTask task = new SafeTask();
        for (int i=0; i<10; i++){
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}