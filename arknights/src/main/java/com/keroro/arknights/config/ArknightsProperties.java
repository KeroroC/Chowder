package com.keroro.arknights.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * arknights配置
 * @author wangpeng
 * @since 2023年12月27日 10:42
 */
@Data
@ConfigurationProperties(prefix = "arknights")
public class ArknightsProperties {

    private String domainName;
}
