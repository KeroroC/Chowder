package xyz.keroro.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.keroro.common.response.ResponseResult;

/**
 * @author wangpeng
 * @since 2024年06月20日 下午5:12
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @PostMapping("/login")
    public ResponseResult<String> login() {
        return ResponseResult.success("123");
    }
}
