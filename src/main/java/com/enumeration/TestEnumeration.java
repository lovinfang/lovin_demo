/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author lovin
 * @version $Id: TestEnumeration.java, v 0.1 2019年03月25日 9:43 lovin Exp $
 */
public class TestEnumeration {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.addElement("Lisa");
        v.addElement("Billy");
        v.addElement("Mr Brown");

        Enumeration e = v.elements();  //返回Enumeration对象
        while(e.hasMoreElements()){
            String value = (String)e.nextElement(); //调用nextElement方法获得元素
            System.out.println(value);
        }
    }
}