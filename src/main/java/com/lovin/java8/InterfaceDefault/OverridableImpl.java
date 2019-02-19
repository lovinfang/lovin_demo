/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.InterfaceDefault;

/**
 *
 * @author wb-fyw404615
 * @version $Id: OverridableImpl.java, v 0.1 2019年02月13日 19:14 wb-fyw404615 Exp $
 */
public class OverridableImpl implements Defaulable {

    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}