/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 *
 * @author lovin
 * @version $Id: OddSupport.java, v 0.1 2019年03月25日 10:41 lovin Exp $
 */
public class OddSupport extends Support{

    public OddSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1){
            return true;
        }
        return false;
    }
}