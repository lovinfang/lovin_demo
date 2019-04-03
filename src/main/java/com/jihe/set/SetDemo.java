/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 *
 * @author wb-fyw404615
 * @version $Id: setDemo.java, v 0.1 2019年04月02日 16:58 wb-fyw404615 Exp $
 */
public class SetDemo {

    public static void main(String[] args) {
        SetDemo setDemo = new SetDemo();
        for (int i=0; i<10; i++){
            setDemo.test1();
            System.out.println("------------------------");
        }

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