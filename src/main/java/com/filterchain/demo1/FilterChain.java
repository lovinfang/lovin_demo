/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 * 过滤器链
 *
 * @author wb-fyw404615
 * @version $Id: FilterChain.java, v 0.1 2019年03月25日 11:07 wb-fyw404615 Exp $
 */
public interface FilterChain {

    void doChain(Request request, Response response, FilterChain filterChain);
}