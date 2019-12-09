/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 责任链实现
 *
 * @author lovin
 * @version $Id: DefaultFilterChain.java, v 0.1 2019年03月25日 11:17 lovin Exp $
 */
public class DefaultFilterChain implements FilterChain {

    private List<Filter> filterList;

    private int pos;

    public DefaultFilterChain(List<Filter> filterList) {
        this.filterList = filterList;
        this.pos = -1;
    }

    @Override
    public void doChain(Request request, Response response, FilterChain filterChain) {
        if (CollectionUtils.isEmpty(filterList)){
            return;
        }
        pos ++;
        if (pos < 0 || pos >= filterList.size()){
            return;
        }
        filterList.get(pos).doFilter(request,response,filterChain);
    }
}