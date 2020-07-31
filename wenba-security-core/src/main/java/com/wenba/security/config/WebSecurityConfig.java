package com.wenba.security.config;

import com.wenba.security.properties.SecurityConstants;
import com.wenba.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @description:
 * @author: tongrongbing
 * @date: 2020-07-28 10:36
 **/
@EnableWebSecurity  // 启动springsecurity 过滤器链功能
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService customUserDetailsService;


    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    private SecurityProperties properties;

    /**
     * @author: tongrongbing
     * @description:  身份认证管理器：
     *                  1。认证信息提供方式(用户名、密码、当前用户的权限信息；2。可采用内存方式，也可以采用数据库方式获取
     * @time: 2020/7/28 10:52 上午
     * @param auth
     * @return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication().withUser("admin")  基于内存
                .password(passwordEncoder().encode("1234"))
                .authorities("ADMIN");*/
        // 基于数据库
        auth.userDetailsService(customUserDetailsService);
    }

    /**
     * @author: tongrongbing
     * @description:  资源权限配置（过滤器链）
     *                 1。拦截的哪一些资源
     *                 2。资源所对应的角色权限
     *                 3。定义认证方式：httpbasi \ httpForm
     *                 4.可以定制登录页面、登录请求地址、错误处理方式
     *                 5。自定义Springsecurity过滤器等
     * @time: 2020/7/28 10:53 上午
     * @param http
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);  // 基于表单登录配置

        http.authorizeRequests() //认证请求
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        "/swagger-resources",
                        properties.getBrowser().getLoginPage()).permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .csrf().disable()
        ;
    }

    /**
     * @author: tongrongbing
     * @description:   静态资源过滤配置
     * @time: 2020/7/30 6:29 下午
     * @param web
     * @return void
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().mvcMatchers("/webjars/**","/doc.html","/swagger-resources","/v2/**");
    }
}
