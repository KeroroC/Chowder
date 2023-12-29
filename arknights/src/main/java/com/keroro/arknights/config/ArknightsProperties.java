package com.keroro.arknights.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * arknights配置
 * @author wangpeng
 * @since 2023年12月27日 10:42
 */
@ConfigurationProperties(prefix = "arknights")
public class ArknightsProperties {

    private String domainAs;

    private String domainAk;

    private String domainWeb;

    public String getDomainAs() {
        return domainAs;
    }

    public void setDomainAs(String domainAs) {
        this.domainAs = domainAs;
    }

    public String getDomainAk() {
        return domainAk;
    }

    public void setDomainAk(String domainAk) {
        this.domainAk = domainAk;
    }

    public String getDomainWeb() {
        return domainWeb;
    }

    public void setDomainWeb(String domainWeb) {
        this.domainWeb = domainWeb;
    }
}
