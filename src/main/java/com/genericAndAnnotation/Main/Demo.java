/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.Main;

import com.genericAndAnnotation.component.ParamQueryComponentImpl;
import com.genericAndAnnotation.model.QrCodeConfigParam;
import com.genericAndAnnotation.model.QrCodeConfigParamRequest;

/**
 *
 * @author wb-fyw404615
 * @version $Id: Demo.java, v 0.1 2019年03月27日 16:43 wb-fyw404615 Exp $
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        QrCodeConfigParamRequest qrCodeConfigParamRequest = new QrCodeConfigParamRequest();
        qrCodeConfigParamRequest.setInstIpRoleId("instIpRoleId");
        qrCodeConfigParamRequest.setChInfo("chInfo");

        ParamQueryComponentImpl paramQueryComponent = new ParamQueryComponentImpl();
        QrCodeConfigParam qrCodeConfigParam = paramQueryComponent.queryUniqueParam(qrCodeConfigParamRequest);
    }
}