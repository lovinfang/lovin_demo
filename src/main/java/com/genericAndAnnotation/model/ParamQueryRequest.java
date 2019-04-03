/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model;

/**
 *
 * @author lovin
 * @version $Id: ParamQueryRequest.java, v 0.1 2019年03月27日 10:58 lovin Exp $
 */
public abstract class ParamQueryRequest<T extends ParamModel> {

    private static final long serialVersionUID = 4639352566779741538L;

    /**
     * 参数模板
     * @return
     */
    public abstract String getParamTpCode();

    /**
     * 构建一个实例
     * @return
     */
    public abstract T newInstance();


}