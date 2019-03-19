/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_three;

/**
 *
 *  泛型方法
 * @author wb-fyw404615
 * @version $Id: GenericMethod.java, v 0.1 2019年03月19日 14:10 wb-fyw404615 Exp $
 */
public class GenericMethod {

    /**
     * 泛型方法的基本介绍
     * @param tclass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tclass) throws InstantiationException,IllegalAccessException{
        T instance = tclass.newInstance();
        return instance;
    }

    public <T> void printMsg (T... args){
        for (T t : args){
            System.out.println("泛型测试: t is "+t);
        }
    }

    public static void main(String[] args) {
        try {
            GenericMethod genericMethod = new GenericMethod();
            Object obj = genericMethod.genericMethod(Class.forName("com.lovin.generic.demo_three.GenericMethod"));
            System.out.println(obj.toString());
            //测试printMsg方法
            genericMethod.printMsg("111",222,"aaaa","2323.4",55.55);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}