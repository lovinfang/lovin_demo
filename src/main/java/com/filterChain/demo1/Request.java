/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.filterchain.demo1;

/**
 * 封装了责任链中的处理请求参数
 *
 * @author wb-fyw404615
 * @version $Id: Request.java, v 0.1 2019年03月25日 11:02 wb-fyw404615 Exp $
 */
public interface Request<T> {

    T get(String key);

}