/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.group;

import com.lovin.java8.stream.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author wb-fyw404615
 * @version $Id: GroupDemo.java, v 0.1 2019年02月19日 15:53 wb-fyw404615 Exp $
 */
public class GroupDemo {

    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>();
        {
            pList.add(new Person("fang",false,61));
            pList.add(new Person("ya",false,59));
            pList.add(new Person("wen",true,18));
        }

        Map<String,List<Person>> result = pList.stream().collect(Collectors.groupingBy((person)->{
            if (person.getAge()>60){
                return "老年人";
            }else if(person.getAge()>40){
                return "中年人";
            }else{
                return "青年人";
            }
        }));
        result.forEach((key,person) -> {
            System.out.println(key+":"+person);
        });

        //多级分组
        Map<String,Map<Boolean,List<Person>>> mresult = pList.stream().collect(Collectors.groupingBy((person) -> {
            if (person.getAge()>60){
                return "老年人";
            }else if(person.getAge()>40){
                return "中年人";
            }else{
                return "青年人";
            }
        },Collectors.groupingBy(Person::isStudent)));
        mresult.forEach((str,p) -> {
            System.out.println(str);
            p.forEach((b,p2)->{
                System.out.println(b+"["+p2+"]");
            });
        });


        Map<String,Long> mmresult =  pList.stream().collect(Collectors.groupingBy((person) -> {
            if (person.getAge()>60){
                return "老年人";
            }else if(person.getAge()>40){
                return "中年人";
            }else{
                return "青年人";
            }
        },Collectors.counting()));
        mmresult.forEach((key,l) -> {
            System.out.println(key+":"+l);
        });

        //将收集器的结果转换成另一种类型
        //Map<Boolean,Integer> map = pList.stream().collect(Collectors.groupingBy(Person::isStudent),
        //        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Person::getAge)), Optional::get));
    }
}