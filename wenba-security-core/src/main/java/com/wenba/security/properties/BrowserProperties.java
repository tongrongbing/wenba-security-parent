package com.wenba.security.properties;

import com.wenba.security.enums.LoginResponseType;

/**
 * @description:
 * @author: tongrongbing
 * @date: 2020-07-30 17:14
 **/
public class BrowserProperties {

    private LoginResponseType loginResponseType;

    private String loginPage = "/imooc-signIn.html";

    public LoginResponseType getLoginResponseType() {
        return loginResponseType;
    }

    public void setLoginResponseType(LoginResponseType loginResponseType) {
        this.loginResponseType = loginResponseType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
