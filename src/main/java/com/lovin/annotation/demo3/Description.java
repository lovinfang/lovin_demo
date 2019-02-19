/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo3;

import java.lang.annotation.*;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Description.java, v 0.1 2019年02月14日 11:17 wb-fyw404615 Exp $
 */

/**
 * 使用@interface关键字定义注解
 * 成员类型是受限的，合法的类型包括原始类型及 String Class Annotation Enumeration
 * 如果注解只有一个成员，则成员名必须取名为value() *有待考察*,在使用时可以忽略成员名和赋值号(=)
 * 注解类可以没有成员，没有成员的注解称为标识注解
 *  Target   Retention  Inherited  Documented 元注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    //成员已无参无异常方式声明
    String desc();

    String author();

    //可以使用default为成员指定一个默认值
    int age() default 18;
}