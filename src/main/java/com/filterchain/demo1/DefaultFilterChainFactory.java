/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

import java.util.List;

/**
 * 责任链工厂实现
 *
 * @author lovin
 * @version $Id: DefaultFilterChainFactory.java, v 0.1 2019年03月25日 11:20 lovin Exp $
 */
public class DefaultFilterChainFactory implements FilterChainFactory{

    private List<Filter> filterList;

    public DefaultFilterChainFactory(List<Filter> filterList) {
        this.filterList = filterList;
    }

    @Override
    public FilterChain create() {
        return new DefaultFilterChain(filterList);
    }
}