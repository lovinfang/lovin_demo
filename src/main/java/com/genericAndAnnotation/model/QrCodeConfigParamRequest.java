/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model;

import com.genericAndAnnotation.annotation.ParamCondition;

/**
 *
 * @author lovin
 * @version $Id: QrCodeConfigParamRequest.java, v 0.1 2019年03月27日 16:39 lovin Exp $
 */
public class QrCodeConfigParamRequest extends ParamQueryRequest<QrCodeConfigParam> {

    private static final long serialVersionUID = -7463615294086659323L;

    /**
     * 机构IpRoleId
     */
    @ParamCondition(QrCodeConfigParam.INST_IP_ROLEID)
    private String instIpRoleId;

    /**
     * 标准渠道标
     */
    @ParamCondition(QrCodeConfigParam.CH_INFO)
    private String chInfo;

    @Override
    public String getParamTpCode() {
        return "121010300";
    }

    @Override
    public QrCodeConfigParam newInstance() {
        return new QrCodeConfigParam();
    }

    public String getInstIpRoleId() {
        return instIpRoleId;
    }

    public void setInstIpRoleId(String instIpRoleId) {
        this.instIpRoleId = instIpRoleId;
    }

    public String getChInfo() {
        return chInfo;
    }

    public void setChInfo(String chInfo) {
        this.chInfo = chInfo;
    }
}