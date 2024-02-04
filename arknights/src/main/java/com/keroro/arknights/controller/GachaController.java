package com.keroro.arknights.controller;

import com.keroro.arknights.service.ArkAccountService;
import com.keroro.arknights.service.ArkGachaService;
import com.keroro.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 抽卡记录控制类
 * @author wangpeng
 * @since 2023年12月29日 22:57
 */
@RestController
@RequestMapping("/gacha")
@Tag(name = "GachaController", description = "抽卡记录控制类")
public class GachaController {

    private final ArkGachaService arkGachaService;

    private final ArkAccountService arkAccountService;

    public GachaController(ArkGachaService arkGachaService, ArkAccountService arkAccountService) {
        this.arkGachaService = arkGachaService;
        this.arkAccountService = arkAccountService;
    }

    /**
     * 更新抽卡记录
     * @param arkAccount ark账号
     * @param channelId 渠道id
     * @return ResponseResult：是否成功
     */
    @GetMapping("/updateByAccount")
    @Operation(operationId = "updateByAccount", summary = "更新抽卡记录", description = "插入新的抽卡记录，不会覆盖以前的")
    @Parameters({
            @Parameter(name = "arkAccount", description = "ark账号", example = "13809041524"),
            @Parameter(name = "channelId", description = "渠道id", example = "1")
    })
    public ResponseResult<String> updateGachaByAccount(@NotBlank String arkAccount, @NotBlank Integer channelId) {
        int count = arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功，新增了" + count + "条记录");
    }

    /**
     * 更新抽卡记录
     * @param arkAccount ark账号
     * @param channelId 渠道id
     * @param token 登录token
     * @return ResponseResult：是否成功
     */
    @GetMapping("/updateByToken")
    @Operation(operationId = "updateByToken", summary = "更新抽卡记录", description = "插入新的抽卡记录，不会覆盖以前的")
    @Parameters({
            @Parameter(name = "arkAccount", description = "ark账号", example = "13809041524"),
            @Parameter(name = "channelId", description = "渠道id", example = "1"),
            @Parameter(name = "token", description = "登录token", example = "LuZp2oWE6pcxJ14i8dG5jSBb")
    })
    public ResponseResult<String> updateGachaByToken(@NotBlank String arkAccount, @NotBlank Integer channelId, @NotBlank String token) {
        arkAccountService.addToken(arkAccount, token);
        int count = arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功，新增了" + count + "条记录");
    }
}
