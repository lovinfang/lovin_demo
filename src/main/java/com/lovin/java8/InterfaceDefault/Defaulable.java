/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.InterfaceDefault;

/**
 * @version $Id: Defaulable.java, v 0.1 2019年02月13日 19:13 lovin Exp $
 */
public interface Defaulable {

    default String notRequired(){
        return "Default implementation";
    }
}