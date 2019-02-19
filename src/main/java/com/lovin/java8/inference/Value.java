/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.inference;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Value.java, v 0.1 2019年02月14日 19:35 wb-fyw404615 Exp $
 */
public class Value< T > {
    public static < T > T defaultValue(){
        return null;
    }

    public T getOrDefault(T value, T defaultValue){
        return (value != null)?value:defaultValue;
    }
}