/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: GenericArray.java, v 0.1 2019年03月19日 15:37 wb-fyw404615 Exp $
 */
public class GenericArray {

    public static void main(String[] args) {
        //List<String>[] ls = new ArrayList<String>[10];   //不能创建一个确切的泛型类型的数组
        List<?>[] lsa = new ArrayList<?>[10];    //使用通配符创建泛型数组是可以的
        List<String>[] lsb = new ArrayList[10];

    }
}