/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo3;

/**
 * @version $Id: Child.java, v 0.1 2019年02月14日 11:32 lovin Exp $
 */
@Description(desc="I am class annotation",author = "lovinfang")
public class Child implements Person{
    @Override
    @Description(desc="i am method annotation",author = "fyw",age = 31)
    public String name() {
        return null;
    }

    @Override
    public String age() {
        return null;
    }

    @Override
    public String sing() {
        return "zhangsan";
    }
}