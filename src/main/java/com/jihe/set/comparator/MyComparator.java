/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.set.comparator;

import com.jihe.set.pojo.Student;

import java.util.Comparator;

/**
 * @version $Id: MyComparator.java, v 0.1 2019年04月02日 17:49 lovin Exp $
 */
public class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // 姓名长度
        int num = s1.getName().length() - s2.getName().length();
        // 姓名内容
        int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
        // 年龄
        int num3 = num2 == 0 ? s1.getAge() - s2.getAge() : num2;
        return num3;
    }
}