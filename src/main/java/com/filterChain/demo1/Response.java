/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 * 封装了责任链中的响应参数
 *
 * @author wb-fyw404615
 * @version $Id: Response.java, v 0.1 2019年03月25日 11:03 wb-fyw404615 Exp $
 */
public interface Response<T> {

    void set(String key,T value);
}