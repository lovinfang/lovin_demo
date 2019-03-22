/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.biz;

import com.processTemplate.model.Result;
import com.processTemplate.request.ModelAddRequest;

/**
 * @author wb-fyw404615
 * @version $Id: DemoManage.java, v 0.1 2019年03月22日 14:23 wb-fyw404615 Exp $
 */
public interface DemoManage {

    Result<Boolean> modeAdd(ModelAddRequest request);
}