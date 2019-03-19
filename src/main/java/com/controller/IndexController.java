/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wb-fyw404615
 * @version $Id: IndexController.java, v 0.1 2019年03月05日 11:16 wb-fyw404615 Exp $
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}