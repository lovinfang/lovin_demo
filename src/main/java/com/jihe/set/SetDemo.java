/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.set;

import com.google.common.collect.Sets;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 *
 * @author lovin
 * @version $Id: setDemo.java, v 0.1 2019年04月02日 16:58 lovin Exp $
 */
public class SetDemo {

    public static void main(String[] args) {
        //SetDemo setDemo = new SetDemo();
        //for (int i=0; i<10; i++){
        //    setDemo.test1();
        //    System.out.println("------------------------");
        //}

        ////Set转List
        //String[] staffs = new String[]{"Tom", "Bob", "Jane"};
        //Set<String> staffsSet = new HashSet<>(Arrays.asList(staffs));
        //List<String> result = new ArrayList<>(staffsSet);
        //result.stream().forEach(p -> {
        //    System.out.println(p);
        //});

        TreeSet<String> test = new TreeSet<String>(
                new Comparator<String>(){
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        test.add("9743243902137284721837213883902139021321");
        test.add("121121212131");
        test.add("6255243254214324");
        test.add("111");
        test.add("08765342");
        test.add("12fdssfdsf");
        System.out.println(test);


        Set<String> set = Sets.newHashSet();
    }

    public void test1(){
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String data : Arrays.asList("B","E","D","C","A")){
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }

        //不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);
        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);
        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);
    }
}