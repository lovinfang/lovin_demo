/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 * 过滤器链
 *
 * @author lovin
 * @version $Id: FilterChain.java, v 0.1 2019年03月25日 11:07 lovin Exp $
 */
public interface FilterChain {

    void doChain(Request request, Response response, FilterChain filterChain);
}