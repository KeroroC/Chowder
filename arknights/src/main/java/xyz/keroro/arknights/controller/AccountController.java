package xyz.keroro.arknights.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.keroro.arknights.dao.po.ArkAccount;
import xyz.keroro.arknights.service.ArkAccountService;
import xyz.keroro.common.response.ResponseResult;

import java.util.List;

/**
 * Ark账号控制类
 * @author wangpeng
 * @since 2023年12月27日 10:35
 */
@Validated
@RestController
@RequestMapping("/account")
public class AccountController {

    private final ArkAccountService arkAccountService;

    public AccountController(ArkAccountService arkAccountService) {
        this.arkAccountService = arkAccountService;
    }

    /**
     * 增加一个账号
     * @param arkAccount 账号（手机号）
     * @param arkPassword 密码
     * @return ResponseResult：是否成功
     */
    @GetMapping("/add")
    public ResponseResult<Boolean> addAccount(@NotBlank String arkAccount, @NotBlank String arkPassword) {
        boolean res = arkAccountService.addAccount(arkAccount, arkPassword);
        if (res) {
            return ResponseResult.success(true);
        } else {
            return ResponseResult.fail(false);
        }
    }

    /**
     * 账号列表
     * @return ResponseResult：是否成功
     */
    @GetMapping("/list")
    public ResponseResult<List<ArkAccount>> addAccount() {
        return ResponseResult.success(arkAccountService.list());
    }

    /**
     * 登录ark账号
     * @param arkAccount 账号
     * @return 是否成功: ResponseResult
     */
    @GetMapping("/arkLogin")
    public ResponseResult<String> arkLogin(@NotBlank String arkAccount) {
        boolean res = arkAccountService.arkLogin(arkAccount);
        if (res) {
            return ResponseResult.success("登录成功");
        } else {
            return ResponseResult.fail("登录失败");
        }
    }

    /**
     * 登出ark账号
     * @param arkAccount 账号
     * @return 是否成功: ResponseResult
     */
    @GetMapping("/arkLogout")
    public ResponseResult<String> arkLogout(@NotBlank String arkAccount) {
        return ResponseResult.success(arkAccountService.arkLogout(arkAccount));
    }
}
