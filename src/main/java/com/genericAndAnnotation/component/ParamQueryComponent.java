/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.component;

import com.genericAndAnnotation.model.ParamModel;
import com.genericAndAnnotation.model.ParamQueryRequest;

import java.util.List;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ParamQueryComponent.java, v 0.1 2019年03月27日 10:56 wb-fyw404615 Exp $
 */
public interface ParamQueryComponent {

    /**
     * 参数中心查询请求参数
     * @param request
     * @param <T>
     * @return
     */
    <T extends ParamModel> T queryUniqueParam(ParamQueryRequest<T> request) throws Exception;

    /**
     *
     *
     * @param request 参数中心查询请求参数
     * @return
     */
    <T extends ParamModel> List<T> queryParams(ParamQueryRequest<T> request) throws Exception;

}