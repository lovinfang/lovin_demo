/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_two;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Box.java, v 0.1 2019年03月15日 14:12 wb-fyw404615 Exp $
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