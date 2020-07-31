package com.wenba.security;

import com.wenba.security.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @description: 自定义UserDetailsService实现类
 * @author: tongrongbing
 * @date: 2020-07-30 14:07
 **/
@Component("customUserDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("access defined CustomUserDetailsService ...username is "+username);
        return new UserInfo(username,passwordEncoder.encode("1234"), AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
    }
}
