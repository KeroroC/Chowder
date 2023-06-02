package com.keroro.chowder.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 测试Swagger
 * @author: wangpeng
 * @date: 2023年04月21日 21:43
 */
@Api(tags = "测试Swagger")
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/calAge")
    @ResponseBody
    @Operation(summary = "计算年龄", description = "描述描述")
    @ApiImplicitParam(paramType = "query", name = "age", value = "年龄", required = true, example = "23")
    public String calAge(String age) {
        return "你的年龄为：" + age;
    }
}
