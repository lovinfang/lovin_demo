/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.inference;

/**
 * @version $Id: TypeInference.java, v 0.1 2019年02月14日 19:39 lovin Exp $
 */
public class TypeInference {

    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        String s = value.getOrDefault("22",Value.defaultValue());
        System.out.println(s);
    }
}