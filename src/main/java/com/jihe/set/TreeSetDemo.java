/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.set;

import com.jihe.set.comparator.MyComparator;
import com.jihe.set.pojo.Student;

import java.util.TreeSet;

/**
 *
 * @author wb-fyw404615
 * @version $Id: TreeSetDemo.java, v 0.1 2019年04月02日 17:07 wb-fyw404615 Exp $
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSetDemo treeSetDemo = new TreeSetDemo();
        //treeSetDemo.test();
        treeSetDemo.test2();
    }

    public void test2(){
        //TreeSet<Student> ts = new TreeSet<Student>();
        // 2.比较器排序
        //比较器排序步骤：
        //1.单独创建一个比较类，这里以MyComparator为例，并且要让其继承Comparator接口
        //2.重写Comparator接口中的Compare方法

        TreeSet<Student> ts = new TreeSet<Student>(new MyComparator());

        //创建元素对象
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }

    public void test(){
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<>();
        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        for (Integer i : ts){
            System.out.println(i);
        }
    }
}