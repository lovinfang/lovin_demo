/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo3;

import sun.security.krb5.internal.crypto.Des;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ParseAnno.java, v 0.1 2019年02月14日 18:30 wb-fyw404615 Exp $
 */
public class ParseAnno {

    public static void main(String[] args) {
        try {
            //1.使用类加载器加载类
            Class c = Class.forName("com.lovin.annotation.demo3.Child");
            //2.找到类上面的注解
            boolean isExists = c.isAnnotationPresent(Description.class);
            if (isExists){
                //3.如果存在就拿到注解实例
                Description description = (Description) c.getAnnotation(Description.class);
                System.out.println(description.desc() + ":" + description.author());
            }
            //4.找到方法上的注解
            Method[] methods = c.getMethods();
            //方式一
            for (Method method : methods){
                boolean isMeAno = method.isAnnotationPresent(Description.class);
                //如果方法上的注解是Description，就拿到注解实例
                if (isMeAno){
                    Description description = method.getAnnotation(Description.class);
                    System.out.println(description.desc() + ":" + description.author());
                }
            }
            //方式二
            for (Method m : methods){
                //拿到方法上所有注解
                Annotation[] as = m.getAnnotations();
                for(Annotation a : as){
                    if(a instanceof Description){
                        Description d = (Description) a;
                        System.out.println(d.desc() + ":" + d.author());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}