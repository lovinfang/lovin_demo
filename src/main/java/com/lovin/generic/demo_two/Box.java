/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_two;

/**
 *
 * @author lovin
 * @version $Id: Box.java, v 0.1 2019年03月15日 14:12 lovin Exp $
 */
public class Box<T> {

    private T data;

    public Box() {}

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}