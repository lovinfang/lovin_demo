/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 *
 * @author wb-fyw404615
 * @version $Id: PermissionValidateFilter.java, v 0.1 2019年03月25日 11:25 wb-fyw404615 Exp $
 */
public class PermissionValidateFilter implements Filter<Request,Response>{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("----------PermissionValidateFilter doFilter---------");
        chain.doChain(request,response,chain);
    }
}