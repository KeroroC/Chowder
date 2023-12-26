package com.keroro.chowder.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试Swagger
 * @author wangpeng
 * @since 2023年04月21日 21:43
 */
@Controller
@RequestMapping("/test")
@Tag(name = "TestController", description = "springdoc测试controller")
public class TestController {

    @GetMapping("/calAge")
    @ResponseBody
    @Operation(summary = "计算年龄", description = "描述描述")
    @Parameter(name = "age", description = "年龄", example = "23")
    public String calAge(String age) {
        return "你的年龄为：" + age;
    }
}
