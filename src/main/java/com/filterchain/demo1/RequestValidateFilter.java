/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 *
 * @author lovin
 * @version $Id: RequestValidateFilter.java, v 0.1 2019年03月25日 11:23 lovin Exp $
 */
public class RequestValidateFilter implements Filter<Request,Response> {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("------RequestValidateFilter doFilter--------------");
        chain.doChain(request,response,chain);
    }
}