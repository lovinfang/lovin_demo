/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo2;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Person.java, v 0.1 2019年02月14日 11:05 wb-fyw404615 Exp $
 */
public interface Person {

    public String name();

    public int age();

    /*@Deprecated 表示该方法已经过时了*/
    @Deprecated
    public void sing();

    /*注：
10      当方法或是类上面有@Deprecated注解时，
11      说明该方法或是类都已经过期不能再用，
12      但不影响以前项目使用，提醒你新替代待的方法或是类
13  */
}