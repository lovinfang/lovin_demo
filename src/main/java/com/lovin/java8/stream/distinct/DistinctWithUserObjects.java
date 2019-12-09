/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.distinct;

import com.lovin.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: DistinctWithUserObjects.java, v 0.1 2019年02月19日 10:56 lovin Exp $
 */
public class DistinctWithUserObjects {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        {
            list.add(new Person("fang",true));
            list.add(new Person("ya",false));
            list.add(new Person("weng",false));
            list.add(new Person("lovin",true));
        }
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct books:"+l);

        list.stream().distinct().forEach(b -> System.out.println(b.getName()+","+(b.isStudent()?"student":"not student")));
    }
}