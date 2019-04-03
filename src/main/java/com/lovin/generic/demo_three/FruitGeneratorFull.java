/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.generic.demo_three;

import java.util.Random;

/**
 *
 * @author lovin
 * @version $Id: FruitGeneratorFull.java, v 0.1 2019年03月19日 12:26 lovin Exp $
 */
public class FruitGeneratorFull implements Generator<String>{

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}