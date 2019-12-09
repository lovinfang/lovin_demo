/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic;

/**
 * @version $Id: StaticGenerator.java, v 0.1 2019年03月19日 15:15 lovin Exp $
 */
public class StaticGenerator {

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }
}