package com.stringDemo;

import java.util.Objects;

/**
 * 如果两个对象相等 == 那么hashcode值一定一样
 * 如果两个对象的hashcode一样，这两个对象并不一定相等
 *
 */
public class HashCodeAndEquals {

    private String userName;

    private String password;

    private Integer age;

    public HashCodeAndEquals(String userName, String password, Integer age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    //重写hashCode() 和equals()方法
    @Override
    public int hashCode() {
//        return Objects.hash(userName, password, age);
        return this.age%3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeAndEquals hashCodeAndEquals = (HashCodeAndEquals) o;
        return Objects.equals(userName, hashCodeAndEquals.userName) &&
                Objects.equals(password, hashCodeAndEquals.password) &&
                Objects.equals(age, hashCodeAndEquals.age);
    }

    public static void main(String[] args) {
        HashCodeAndEquals test1 = new HashCodeAndEquals("aaa","aaa",1);
        HashCodeAndEquals test2 = new HashCodeAndEquals("aaa","aaa",1);
        HashCodeAndEquals test3 = new HashCodeAndEquals("ccc","ccc",4);
        if (test1.hashCode() == test3.hashCode()){
            System.out.println("test1  和 test3 的hashcode值相同");
        }
        if(test1.equals(test3)){
            System.out.println("test1  和 test3 equals");
        }
        if (test1 == test3){
            System.out.println("test1  和 test3相等");
        }
        if(test1.equals(test2)){
            System.out.println("test1  和 test2 equals");
        }
        if (test1 == test2){
            System.out.println("test1  和 test2相等");
        }
    }
}
