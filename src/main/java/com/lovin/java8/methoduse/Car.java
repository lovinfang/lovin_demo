/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.methoduse;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @version $Id: Car.java, v 0.1 2019年02月13日 19:28 lovin Exp $
 */
public class Car {

    private String name;

    private String price;

    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.out.println("Collided "+car.toString());
    }

    public void follow(final Car another){
        System.out.println("Following the "+ another.toString());
    }

    public void repair(){
        System.out.println("Repaired " + this.toString());
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return "TOYOTO";
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>price</tt>.
     *
     * @return property value of price
     */
    public String getPrice() {
        return "10000RMB";
    }

    /**
     * Setter method for property <tt>price</tt>.
     *
     * @param price value to be assigned to property price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}