/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Filter.java, v 0.1 2019年03月25日 11:02 wb-fyw404615 Exp $
 */
public interface Filter<T extends Request, R extends Response> {

    void doFilter(T request, R response, FilterChain chain);
}