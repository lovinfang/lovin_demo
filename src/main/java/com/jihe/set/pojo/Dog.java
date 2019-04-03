/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jihe.set.pojo;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Dog.java, v 0.1 2019年04月02日 17:54 wb-fyw404615 Exp $
 */
public class Dog implements Comparable<Dog> {

    int size;

    public Dog(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog{" + "size=" + size + '}';
    }

    @Override
    public int compareTo(Dog o) {
        //数值大小比较
        return size - o.size;
    }
}