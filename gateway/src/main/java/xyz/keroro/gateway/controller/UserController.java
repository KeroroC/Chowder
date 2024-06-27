package xyz.keroro.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.keroro.common.response.ResponseResult;
import xyz.keroro.gateway.dao.po.User;
import xyz.keroro.gateway.service.UserService;

/**
 * 用户控制类
 * @author wangpeng
 * @since 2024年06月20日 下午10:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseResult<String> addUser(@RequestBody User user) {
        ResponseResult<String> result = ResponseResult.success("新增用户成功");
        if (!userService.addUser(user)) {
            result = ResponseResult.fail("新增用户失败");
        }
        return result;
    }
}
