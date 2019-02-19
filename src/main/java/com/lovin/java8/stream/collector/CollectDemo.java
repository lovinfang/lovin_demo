/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.collector;

import com.lovin.java8.stream.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author wb-fyw404615
 * @version $Id: CollectDemo.java, v 0.1 2019年02月19日 15:04 wb-fyw404615 Exp $
 */
public class CollectDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(14,15,16,17);

        long count = list.stream().collect(Collectors.counting());
        System.out.println("count:"+count); //计算集合中的个数，并不是求和

        count = list.stream().count();
        System.out.println("count:"+count);

        //最值
        List<Person> pList = new ArrayList<>();
        {
            pList.add(new Person("fang",false,31));
            pList.add(new Person("ya",false,29));
            pList.add(new Person("wen",true,18));
        }
        Optional<Person> oldPerson = pList.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println("年龄最大的人是:"+oldPerson.get());

        //求和
        int sum = pList.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println("年龄之和:"+sum);

        //求平均值
        double avg = pList.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("平均值:"+avg);

        //Collectors.summarizingInt函数能一次性将最值、均值、总和、元素个数全部计算出来，并存储在对象IntSummaryStatisics中。
        //可以通过该对象的getXXX()函数获取这些值。
        IntSummaryStatistics intSummaryStatistics = pList.stream().collect(Collectors.summarizingInt(Person::getAge));
        double i = intSummaryStatistics.getAverage();
        System.out.println(i);

        String names = pList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(names);

        //Optional<Integer> sumAge = pList.stream().collect(Collectors.reducing(0,Person::getAge,(k,j)->k+j));
        //Optional<Integer> sumAge = pList.stream().filter(Person::getAge).collect(Collectors.reducing((k,j)->k+j));
    }
}