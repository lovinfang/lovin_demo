/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.option;

import com.lovin.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @version $Id: OptionDemo.java, v 0.1 2019年02月19日 11:32 lovin Exp $
 */
public class OptionDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        {
            list.add(new Person("fang",false));
            list.add(new Person("ya",false));
            list.add(new Person("wen",true));
        }

        Optional<Person> person = list.stream().findFirst();
        System.out.println(person);

        Optional<Person> person2 = list.stream().findAny();
        System.out.println(person2);

        boolean b = person2.isPresent();
        System.out.println("isPresent,判断容器中是否有值:"+b);

        //容器若不为空则执行括号中的Lambda表达式。
        person2.ifPresent(p -> System.out.println(p.getName()));

        Person p = person2.get();
        System.out.println("get() 获取容器中的元素，若容器为空则抛出NoSuchElement异常:"+p.getName());

        p = person2.orElse(new Person("another",true));
        System.out.println("orElse() 获取容器中的元素，若容器为空则返回括号中的默认值:"+p.getName());

        List<Person> temp = new ArrayList<>();
        Optional<Person> optional = temp.stream().findAny();
        p = optional.orElse(new Person("another",true));
        System.out.println("orElse() 获取容器中的元素，若容器为空则返回括号中的默认值:"+p.getName());
    }
}