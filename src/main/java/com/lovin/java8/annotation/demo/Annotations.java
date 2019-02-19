/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Annotations.java, v 0.1 2019年02月14日 19:42 wb-fyw404615 Exp $
 */
public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
    public @interface NonEmpty{}

    public static class Holder< @NonEmpty T> extends @NonEmpty Object{
        public void method() throws @NonEmpty Exception{}
    }

    public static void main(String[] args) {
        final Holder< String > holder = new @NonEmpty Holder<String>();
        @NonEmpty Collection<@NonEmpty String> strings = new ArrayList<>();
    }
}