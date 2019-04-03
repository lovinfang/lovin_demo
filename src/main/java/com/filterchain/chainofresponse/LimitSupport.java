/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 * 解决指定范围内的问题
 *
 * @author lovin
 * @version $Id: LimitSupport.java, v 0.1 2019年03月25日 10:38 lovin Exp $
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit){
            return true;
        }
        return false;
    }
}