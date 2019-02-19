/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Person.java, v 0.1 2019年02月18日 17:01 wb-fyw404615 Exp $
 */
public class Person {

    private String name;

    private boolean isStudent;

    private int age;

    public Person() {
    }

    public Person(String name, boolean isStudent) {
        this.name = name;
        this.isStudent = isStudent;
    }

    public Person(String name, boolean isStudent, int age) {
        this.name = name;
        this.isStudent = isStudent;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isStudent=" + isStudent +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (name == null?0:name.hashCode());
        return hashno;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        final Person person = (Person) obj;
        if(this == person){
            return true;
        }else{
            return (this.name.equals(person.getName()) && (this.isStudent == person.isStudent) && this.age == person.getAge());
        }
    }
}