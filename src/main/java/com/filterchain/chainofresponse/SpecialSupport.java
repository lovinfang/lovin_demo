/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 *
 * @author wb-fyw404615
 * @version $Id: SpecialSupport.java, v 0.1 2019年03月25日 10:42 wb-fyw404615 Exp $
 */
public class SpecialSupport extends Support{

    private int number;

    public SpecialSupport(String name, int number){
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number){
            return true;
        }
        return false;
    }
}