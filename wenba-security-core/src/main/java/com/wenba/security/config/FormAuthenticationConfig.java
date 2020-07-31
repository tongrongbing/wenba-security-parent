package com.wenba.security.config;


import com.wenba.security.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @description:  封装表单登录认证配置
 * @author: tongrongbing
 * @date: 2020-07-30 16:17
 **/
@Component
public class FormAuthenticationConfig {

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    public void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL)
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                ;
    }
}
