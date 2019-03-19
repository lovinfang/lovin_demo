/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_two;

/**
 *
 * @author wb-fyw404615
 * @version $Id: GenericTest.java, v 0.1 2019年03月15日 14:13 wb-fyw404615 Exp $
 */
public class GenericTest {

    public static void main(String[] args) {

        GenericTest test = new GenericTest();
        test.test1();
        test.test4();

    }

    private void test1(){
        Box<String> name = new Box<>("corn");
        Box<Integer> age = new Box<Integer>(712);

        System.out.println("name:"+name.getData());
        System.out.println("age class:" + age.getClass());
        System.out.println(name.getClass() == age.getClass()); //true
    }

    private void test2(){
        Box<Number> name = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(712);

        getData(name);
        //getData(age);   //报错  Number是Integer的父类
    }

    private void test3(){
        Box<Integer> a = new Box<Integer>(712);
        //Box<Number> b = a;  // 1
        Box<Float> f = new Box<Float>(3.14f);
        //b.setData(f);        // 2
    }

    private void test4(){
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);
        getData2(name);
        getData2(age);
        getData2(number);
    }

    private void test5(){
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        //getData(name);
        //getData(age);
        getData(number);

        //getUpperNumberData(name); // 1
        getUpperNumberData(age);
        getUpperNumberData(number);
    }


    public void getData2(Box<?> data){
        System.out.println("data2:"+data.getData());
    }

    public void getData(Box<Number> data){
        System.out.println("data:"+data.getData());
    }

    public void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data:"+data.getData());
    }
}