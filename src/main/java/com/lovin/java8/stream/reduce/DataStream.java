/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.reduce;

import com.lovin.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @version $Id: DataStream.java, v 0.1 2019年02月19日 14:39 lovin Exp $
 */
public class DataStream {

    /**
     * 采用reduce进行数值操作会涉及到基本数值类型和引用数值类型之间的装箱、拆箱操作，因此效率较低。
     * 当流操作为纯数值操作时，使用数值流能获得较高的效率。
     * StreamAPI提供了三种数值流：IntStream、DoubleStream、LongStream，也提供了将普通流转换成数值流的三种方法：mapToInt、mapToDouble、mapToLong。
     */
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        {
            list.add(new Person("fang",false,31));
            list.add(new Person("ya",false,29));
            list.add(new Person("wen",true,18));
        }

        //将普通流转换成数值流
        IntStream stream = list.stream().mapToInt(Person::getAge);

        //数值计算
        OptionalInt maxAge = list.stream().mapToInt(Person::getAge).max();
        System.out.println("年龄最大的是:"+maxAge.getAsInt());
    }
}