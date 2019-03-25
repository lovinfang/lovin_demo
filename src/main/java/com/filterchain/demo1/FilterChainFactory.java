/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 * 责任链工厂
 *
 * @author wb-fyw404615
 * @version $Id: FilterChainFactory.java, v 0.1 2019年03月25日 11:09 wb-fyw404615 Exp $
 */
public interface FilterChainFactory {

    FilterChain create();
}