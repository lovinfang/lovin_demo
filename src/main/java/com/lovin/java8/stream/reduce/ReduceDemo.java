/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.reduce;

import com.lovin.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ReduceDemo.java, v 0.1 2019年02月19日 14:16 wb-fyw404615 Exp $
 */
public class ReduceDemo {

    public static void main(String[] args) {
        //List<Person> list = new ArrayList<>();
        //{
        //    list.add(new Person("fang",false,31));
        //    list.add(new Person("ya",false,29));
        //    list.add(new Person("wen",true,18));
        //}

        List<Integer> list = new ArrayList<>();
        {
            list.add(10);
            list.add(13);
            list.add(12);
            list.add(15);
        }
        int age = list.stream().reduce(0,Integer::sum);
        System.out.println(age);
    }
}