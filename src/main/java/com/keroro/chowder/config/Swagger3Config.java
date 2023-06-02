package com.keroro.chowder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;

import java.util.ArrayList;

/**
 * @Description: Swagger3配置类
 * @author: wangpeng
 * @date: 2023年04月21日 22:10
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 是否开启swagger
                .enable(true)
                .select()
                // 过滤条件，扫描指定路径下的文件
                .apis(RequestHandlerSelectors.basePackage("com.keroro.chowder.web.controller"))
                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        /*作者信息*/
        Contact contact = new Contact("Keroro", "https://keroro.club", "keroro714@qq.com");
        return new ApiInfo(
                "Chowder",
                "Keroro's chowder project 接口文档",
                "v1.0",
                "https://keroro.club",
                contact,
                "MIT",
                "https://mit-license.org/",
                new ArrayList<>()
        );
    }
}
