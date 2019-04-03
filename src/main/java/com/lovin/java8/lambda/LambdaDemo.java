/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.lambda;

import java.util.Arrays;

/**
 *
 * @version $Id: LambdaDemo.java, v 0.1 2019年02月02日 11:02 lovin Exp $
 */
public class LambdaDemo {

    public static void main(String[] args) {
        Arrays.asList("a","b","c","d").forEach(e -> System.out.print(e));
        System.out.println("\n---------------");
        Arrays.asList("e","f","g","h").forEach((String e) -> System.out.print(e));
        System.out.println("\n---------------");
        Arrays.asList("i","j","k","l").forEach(e -> {
            System.out.print(e);
        });
        System.out.println("\n---------------");
        String seprator = ",";  //lambda会将类成员变量或者局部变量转换成final类型，所以这里seprator不用显示定义成final类型
        Arrays.asList("a","b","c","d").forEach((String e) -> {
            //seprator ++;   这里不允许再修改seprator的值
            System.out.print(e + seprator);
        });
        System.out.println("\n---------------");
        Arrays.asList("a","b","c","d").sort((String e1,String e2) -> {
            System.out.println("e1="+e1);
            System.out.println("e2="+e2);
            return e1.compareTo(e2);
        });
        Arrays.asList("a","b","c","d").sort((String e1,String e2) -> e1.compareTo(e2) );
        Arrays.asList("a","b","c","d").sort((String e1,String e2) -> { return e1.compareTo(e2);}); //使用花括号就要返回值
    }

}