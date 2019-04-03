/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream.distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version $Id: DistinctSimpleDemo.java, v 0.1 2019年02月19日 10:53 lovin Exp $
 */
public class DistinctSimpleDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA","BB","CC","DD","BB","CC","AA");
        //不重复的数据集合
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct elements:"+l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }
}