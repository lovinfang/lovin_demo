/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.concurrent.threadLocal;

/**
 *
 *  参考 https://www.cnblogs.com/dolphin0520/p/3920407.html
 * @version $Id: ThreadLocalDemo.java, v 0.1 2019年03月20日 18:07 lovin Exp $
 */
public class ThreadLocalDemo {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longLocal.get();
    }

    public String getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo demo = new ThreadLocalDemo();

        demo.set();
        System.out.println(demo.getLong());
        System.out.println(demo.getString());

        Thread t1 = new Thread(){
            @Override
            public void run() {
                demo.set();
                System.out.println(demo.getLong());
                System.out.println(demo.getString());
            }
        };
        t1.start();
        t1.join();

        System.out.println(demo.getString());
        System.out.println(demo.getLong());
    }
}