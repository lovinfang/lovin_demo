/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.concurrent.threadLocal.demo2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.ibm.com/developerworks/cn/java/j-threads/index3.html
 *
 *  ThreadLocal 的糟糕实现
 * @version $Id: ThreadLocal.java, v 0.1 2019年03月20日 19:15 lovin Exp $
 */
public class ThreadLocal {

    private Map values = Collections.synchronizedMap(new HashMap<>());

    public Object get(){
        Thread curThread =Thread.currentThread();
        Object o = values.get(curThread);
        if (o == null && !values.containsKey(curThread)){
            o = initialValue();
            values.put(curThread,o);
        }
        return o;
    }

    public void set(Object newValue){
        values.put(Thread.currentThread(),newValue);
    }

    public Object initialValue(){
        return null;
    }
}