package xyz.keroro.chowder.web.controller;

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
public class TestController {

    @GetMapping("/calAge")
    @ResponseBody
    public String calAge(String age) {
        return "你的年龄为：" + age;
    }
}
