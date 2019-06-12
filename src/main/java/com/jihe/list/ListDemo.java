/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author lovin
 * @version $Id: ListDemo.java, v 0.1 2019年04月03日 16:56 lovin Exp $
 *
 * 排序:List的排序的话就是使用Collections的sort方法，构造Comparator或者让List中的对象实现Comparaable都可以
 * 去重:第一种：用Iterator遍历，遍历出来的放到一个临时List中，放之前用contains判断一下。
 *      第二种：利用set的不可重复性,只需三步走。
 *
 * https://blog.csdn.net/HHcoco/article/details/53117525
 */
public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("fang");
        list.add("fang");
        list.add("ya");
        list.add("ya");
        list.add("wen");


        HashSet tempSet = new HashSet(list);
        list.clear();
        list.addAll(tempSet);
        for (String s : list){
            System.out.println(s);
        }

        List<String> list2 = Lists.newArrayListWithCapacity(4);
        System.out.println(list2.size()); // 0

    }
}