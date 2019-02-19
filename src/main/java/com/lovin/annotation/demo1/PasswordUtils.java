/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.annotation.demo1;

/**
 *
 * @author wb-fyw404615
 * @version $Id: PasswordUtils.java, v 0.1 2019年02月14日 10:40 wb-fyw404615 Exp $
 */
public class PasswordUtils {

    @UseCase(id=47,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
}