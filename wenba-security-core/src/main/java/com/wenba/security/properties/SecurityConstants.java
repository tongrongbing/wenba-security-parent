package com.wenba.security.properties;

/**
 * @description: security相关的常量配置
 * @author: tongrongbing
 * @date: 2020-07-30 16:22
 **/
public interface SecurityConstants {

    /**
     *
     * 当页面请求进行认证时候，会跳转到该url进行处理
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     *
     * 默认的用户名密码登录请求处理url
     *
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL = "/authentication/form";

}
