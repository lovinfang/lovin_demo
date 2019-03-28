/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.model;

import com.genericAndAnnotation.annotation.ParamCondition;

/**
 *
 * @author wb-fyw404615
 * @version $Id: QrCodeConfigParam.java, v 0.1 2019年03月27日 16:38 wb-fyw404615 Exp $
 */
public class QrCodeConfigParam extends ParamModel {

    private static final long serialVersionUID = 845317772556445637L;

    public static final String INST_IP_ROLEID = "instIpRoleId";
    public static final String CH_INFO        = "chInfo";
    public static final String EXTEND_INFO    = "extendInfo";
    public static final String UNIQUE_ID      = "uniqueId";

    /**
     * 机构IpRoleId
     */
    @ParamCondition(INST_IP_ROLEID)
    private String instIpRoleId;

    /**
     * 标准渠道标
     */
    @ParamCondition(CH_INFO)
    private String chInfo;

    /**
     * 大字段：运营产品码、前准入判断、准入判断
     */
    @ParamCondition(EXTEND_INFO)
    private String extendInfo;

    /**
     * 目标页
     */
    @ParamCondition(UNIQUE_ID)
    private String uniqueId;

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

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}