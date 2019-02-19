/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.annotation.RepeatAnnotation;

import java.lang.annotation.*;

/**
 *
 * @author wb-fyw404615
 * @version $Id: RepeatingAnnotations.java, v 0.1 2019年02月14日 9:55 wb-fyw404615 Exp $
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable{}

    public static void main(String[] args) {
        for (Filter filter:Filterable.class.getAnnotationsByType(Filter.class)){
            System.out.println(filter.value());
        }
    }
}