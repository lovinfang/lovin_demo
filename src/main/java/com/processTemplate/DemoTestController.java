/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate;

import com.processTemplate.biz.impl.DemoManageImpl;
import com.processTemplate.model.Result;
import com.processTemplate.request.ModelAddRequest;
import com.processTemplate.util.LoggerUtil;
import com.processTemplate.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对整个业务逻辑进行测试
 * @author lovin
 * @version $Id: DemoTestController.java, v 0.1 2019年03月22日 15:12 lovin Exp $
 */
public class DemoTestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoTestController.class);

    public void test(){
        DemoManageImpl demoManage = new DemoManageImpl();  //此处本应该是调用注入的DemoManage服务
        ModelAddRequest request = new ModelAddRequest();
        request.setName("lovin");
        request.setType("type");
        Result<Boolean> result = demoManage.modeAdd(request);
        if (result.isSuccess()){
            LoggerUtil.info(LOGGER,"业务逻辑执行成功");
        }else{
            System.out.println(ResultUtil.fetchCurrentErrorMessage(result));
            LoggerUtil.error(LOGGER,ResultUtil.fetchCurrentErrorMessage(result));
        }
    }

    public static void main(String[] args) {
        DemoTestController demoTestController = new DemoTestController();
        demoTestController.test();
    }
}