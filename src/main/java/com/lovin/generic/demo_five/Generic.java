/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_five;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Generic.java, v 0.1 2019年03月19日 15:19 wb-fyw404615 Exp $
 */
public class Generic<T extends Number> {

    private T key;

    public Generic() {
    }

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void showKeyValue(Generic<? extends Number> obj){
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :"+container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
        Generic generic = new Generic();

        //Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);

        generic.showKeyValue(generic2);
        generic.showKeyValue(generic3);
        generic.showKeyValue(generic4);
    }
}