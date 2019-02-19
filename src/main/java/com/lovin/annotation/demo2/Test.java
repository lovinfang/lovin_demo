/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo2;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Test.java, v 0.1 2019年02月14日 11:07 wb-fyw404615 Exp $
 */
public class Test {

    /*@SuppressWarnings 表示忽略指定警告*/
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Person p = new Child();
        p.sing();
    }
}