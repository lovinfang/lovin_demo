/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Test.java, v 0.1 2019年02月14日 10:43 wb-fyw404615 Exp $
 */
public class Test {

    public static void trackUseCases(List<Integer> useCases,Class<?> c){
        for(Method m : c.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        useCases.forEach(e -> System.out.println("Warning: Missing use case-" + e));
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PasswordUtils.class);
    }
}