package xyz.keroro.arknights.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.keroro.arknights.service.ArkAccountService;
import xyz.keroro.arknights.service.ArkGachaService;
import xyz.keroro.common.response.ResponseResult;

/**
 * 抽卡记录控制类
 * @author wangpeng
 * @since 2023年12月29日 22:57
 */
@RestController
@RequestMapping("/gacha")
public class GachaController {

    private final ArkGachaService arkGachaService;

    private final ArkAccountService arkAccountService;

    public GachaController(ArkGachaService arkGachaService, ArkAccountService arkAccountService) {
        this.arkGachaService = arkGachaService;
        this.arkAccountService = arkAccountService;
    }

    /**
     * 更新抽卡记录
     * 插入新的抽卡记录，不会覆盖以前的
     * @param arkAccount ark账号
     * @param channelId 渠道id
     * @return ResponseResult：是否成功
     */
    @GetMapping("/updateByAccount")
    public ResponseResult<String> updateGachaByAccount(@NotBlank String arkAccount, @NotBlank Integer channelId) {
        int count = arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功，新增了" + count + "条记录");
    }

    /**
     * 更新抽卡记录
     * 插入新的抽卡记录，不会覆盖以前的
     * @param arkAccount ark账号
     * @param channelId 渠道id
     * @param token 登录token
     * @return ResponseResult：是否成功
     */
    @GetMapping("/updateByToken")
    public ResponseResult<String> updateGachaByToken(@NotBlank String arkAccount, @NotBlank Integer channelId, @NotBlank String token) {
        arkAccountService.addToken(arkAccount, token);
        int count = arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功，新增了" + count + "条记录");
    }
}
