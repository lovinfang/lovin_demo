/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.InterfaceDefault;

import java.util.function.Supplier;

/**
 *
 * @author wb-fyw404615
 * @version $Id: DefaulableFactory.java, v 0.1 2019年02月13日 19:15 wb-fyw404615 Exp $
 */
public interface DefaulableFactory {

    static Defaulable create(Supplier<Defaulable> supplier){
        return supplier.get();
    }
}