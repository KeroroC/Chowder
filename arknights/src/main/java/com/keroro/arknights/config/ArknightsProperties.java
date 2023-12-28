package com.keroro.arknights.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * arknights配置
 * @author wangpeng
 * @since 2023年12月27日 10:42
 */
@ConfigurationProperties(prefix = "arknights")
public class ArknightsProperties {

    private String domainName;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
