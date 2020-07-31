package com.wenba.security.controller;

import com.wenba.http.ApiResponse;
import com.wenba.security.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: tongrongbing
 * @date: 2020-07-30 16:45
 **/
@RestController
@Slf4j
public class SecurityController {

    /**requestCache 缓存引发跳转的url  */
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties properties;
    /**
     * @author: tongrongbing
     * @description:  当springsecurity对之前请求需要做认证授权时候，springsecurity内部会主动
     *               跳转到/authentication/require路径上进行认证分析。/authentication/require是在配置中
     *               进行配置的。
     * @time: 2020/7/6 22:36
     * @param request
     * @param response
     * @return com.imooc.security.core.support.ApiResponseUtil
     */
    @RequestMapping("/authentication/require")
    public ApiResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的 url:{}",redirectUrl);
            if(StringUtils.endsWithIgnoreCase(redirectUrl,".html")){
                redirectStrategy.sendRedirect(request,response,properties.getBrowser().getLoginPage());
            }
        }
        return  new ApiResponse(null,200,"请引导用户进行登陆");
    }
}
