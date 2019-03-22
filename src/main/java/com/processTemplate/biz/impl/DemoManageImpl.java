/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.biz.impl;

import com.processTemplate.biz.DemoManage;
import com.processTemplate.model.Result;
import com.processTemplate.request.ModelAddRequest;
import com.processTemplate.template.ProcessCallback;
import com.processTemplate.template.ProcessTemplate;
import com.processTemplate.util.validator.ParametorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wb-fyw404615
 * @version $Id: DemoManageImpl.java, v 0.1 2019年03月22日 14:24 wb-fyw404615 Exp $
 */
public class DemoManageImpl implements DemoManage {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoManageImpl.class);

    @Override
    public Result<Boolean> modeAdd(ModelAddRequest request) {
        return ProcessTemplate.execute(new ProcessCallback<Boolean>() {
            @Override
            public void checkParams() {
                LOGGER.info("对参数进行格式校验");
                ParametorValidator.validate(request);
            }

            @Override
            public Boolean process() {
                LOGGER.info("执行相对应的业务逻辑");
                return true;
            }
        },LOGGER);
    }
}