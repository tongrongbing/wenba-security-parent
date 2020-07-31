package com.wenba.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: tongrongbing
 * @date: 2020-07-30 17:11
 **/
@ConfigurationProperties(prefix = "wenba.security")
public class SecurityProperties {

    private BrowserProperties browser;

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
