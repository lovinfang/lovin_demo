/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.chainofresponse;

/**
 *  一个永远不解决问题的类
 *
 * @author lovin
 * @version $Id: NoSupport.java, v 0.1 2019年03月25日 10:37 lovin Exp $
 */
public class NoSupport extends Support {

    public NoSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}