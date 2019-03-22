/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.processTemplate.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ModelAddRequest.java, v 0.1 2019年03月22日 14:46 wb-fyw404615 Exp $
 */
public class ModelAddRequest {

    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空")
    @Length(min = 2, max = 256, message = "名称长度必须在2到256个字符之间")
    @Pattern(regexp = "^[a-zA-Z0-9\u4E00-\u9FA5]+$", message = "名称格式不正确")
    private String name;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}