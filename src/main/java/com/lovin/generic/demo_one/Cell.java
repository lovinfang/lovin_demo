/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_one;

/**
 *
 * @author lovin
 * @version $Id: Cell.java, v 0.1 2019年03月15日 11:28 lovin Exp $
 */
public class Cell<T> {

    private final int id;

    private final T value;

    private static int count = 0;

    private static synchronized int nextId(){
        return count ++;
    }

    public Cell(T value){
        this.value = value;
        id = nextId();
    }

    public int getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public static synchronized int getCount(){
        return count;
    }
}