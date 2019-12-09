/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 *
 * @author lovin
 * @version $Id: ProcessFilter.java, v 0.1 2019年03月25日 11:27 lovin Exp $
 */
public class ProcessFilter implements Filter<Request,Response> {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("---------ProcessFilter doFilter------------");
        chain.doChain(request,response,chain);
    }
}