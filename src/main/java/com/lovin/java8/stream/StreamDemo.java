/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author wb-fyw404615
 * @version $Id: StreamDemo.java, v 0.1 2019年02月18日 16:50 wb-fyw404615 Exp $
 */
public class StreamDemo {

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        System.out.println("----------test---------------");
        streamDemo.test();
        System.out.println("----------test1---------------");
        streamDemo.test1();
        System.out.println("----------test2---------------");
        streamDemo.test2();
    }

    private void test() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Stream<String> stream1 = list.stream();

        String [] names = {"fang","ya","wen"};
        Stream<String> stream2 = Arrays.stream(names);
        Stream<String> stream3 = Stream.of("fang","ya","wen");
    }

    /**
     * .map(line->line.split(" "));    按照空格分词
     * .map(Arrays::stream)            分完词之后，每个元素变成了一个String[]数组。
     * .flagmap(Arrays::stream)        此时一个大流里面包含了一个个小流，我们需要将这些小流合并成一个流。
     */
    private void test2() {
        List<String> list = Arrays.asList("I am a boy","I love the girl","But the girl loves another girl");
        list.stream().map(line -> line.split(" ")).map(Arrays::stream).collect(Collectors.toList());
        List<String> dd = list.stream().map(line -> line.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(dd);
    }

    private void test1() {
        List<Person> list = Arrays.asList(new Person("lovin",false),
                                          new Person("lovin",false),
                                          new Person("fang",true),
                                          new Person("ya",false),
                                          new Person("wen",true));
        //筛选
        List<Person> stream = list.stream().filter(Person::isStudent).collect(Collectors.toList());
        System.out.println(stream);

        //去重distinct 需要Person实现hashcode 和 equals方法
        stream = list.stream().distinct().collect(Collectors.toList());
        System.out.println(stream);

        //截取流的前N个元素
        stream = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(stream);

        //跳过流的前n个元素：
        stream = list.stream().skip(3).collect(Collectors.toList());
        System.out.println(stream);

        //对流中的每个元素执行一个函数，使得元素转换成另一种类型输出
        List<String> streamName = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(streamName);

        //anyMatch用于判断流中是否存在至少一个元素满足指定的条件，这个判断条件通过Lambda表达式传递给anyMatch，执行结果为boolean类型。
        boolean anymatch = list.stream().anyMatch(Person::isStudent);
        System.out.println(anymatch?"there has student [anymatch="+anymatch+"]":"there has no student [anymatch="+anymatch+"]");

        //是否匹配所有元素：allMatch
        boolean allmatch = list.stream().allMatch(Person::isStudent);
        System.out.println(allmatch?"all are student [allmatch="+allmatch+"]":"not all are student [allmatch="+allmatch+"]");

        //noneMatch与allMatch恰恰相反，它用于判断流中的所有元素是否都不满足指定条件：
        boolean nonematch = list.stream().noneMatch(Person::isStudent);
        System.out.println(nonematch?"there has no student [nonematch="+nonematch+"]":"there has student [nonematch="+nonematch+"]");

    }
}
