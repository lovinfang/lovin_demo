/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo2;

/**

 * @version $Id: Child.java, v 0.1 2019年02月14日 11:06 lovin Exp $
 */
public class Child implements Person {

    /*@Override 表示覆盖或重写父类的方法*/
    @Override
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}