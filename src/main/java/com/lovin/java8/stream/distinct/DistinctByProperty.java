/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.distinct;

import com.lovin.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @version $Id: DistinctByProperty.java, v 0.1 2019年02月19日 11:02 lovin Exp $
 */
public class DistinctByProperty {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        {
            list.add(new Person("fang",true));
            list.add(new Person("ya",false));
            list.add(new Person("weng",false));
            list.add(new Person("lovin",true));
            list.add(new Person("ya",false));
            list.add(new Person("lovin",true));
        }

        list.stream().filter(distinctByKey(b -> b.getName())).forEach(b -> System.out.println(b.getName()+","+(b.isStudent()?"student":"not student")));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T,?> keyExtractor){
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t),Boolean.TRUE) == null;
    }
}