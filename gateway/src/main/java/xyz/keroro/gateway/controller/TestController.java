package xyz.keroro.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeng
 * @since 2024年06月20日 下午2:53
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "success";
    }

    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }
}
