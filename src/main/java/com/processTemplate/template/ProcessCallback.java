/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.template;

/**
 *
 * @author lovin
 * @version $Id: ProcessCallback.java, v 0.1 2019年03月21日 16:25 lovin Exp $
 */
public interface ProcessCallback<T> {

    /**
     * 检查入参
     */
    void checkParams();

    /**
     * 执行处理
     * @return
     */
    T process();
}