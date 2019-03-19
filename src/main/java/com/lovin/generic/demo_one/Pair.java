/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_one;

/**
 * @author wb-fyw404615
 * @version $Id: Pair.java, v 0.1 2019年03月15日 11:23 wb-fyw404615 Exp $
 */
public class Pair<T, U> {

    private final T first;

    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(2,"generic test");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}