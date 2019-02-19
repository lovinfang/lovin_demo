/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.option;

import java.util.Optional;

/**
 *
 * @author wb-fyw404615
 * @version $Id: OptionDemo.java, v 0.1 2019年02月15日 10:00 wb-fyw404615 Exp $
 */
public class OptionDemo {

    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        //如果Optional实例持有一个非空值，则isPresent()方法返回true，否则返回false；
        System.out.println("Full Name is set? " + fullName.isPresent());
        //orElseGet()方法，Optional实例持有null，则可以接受一个lambda表达式生成的默认值
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        //map()方法可以将现有的Opetional实例的值转换成新的值；orElse()方法与orElseGet()方法类似，但是在持有null的时候返回传入的默认值。
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        System.out.println("================================================");

        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }
}