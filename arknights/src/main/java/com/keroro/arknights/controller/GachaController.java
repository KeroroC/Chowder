package com.keroro.arknights.controller;

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

    public GachaController(ArkGachaService arkGachaService) {
        this.arkGachaService = arkGachaService;
    }

    /**
     * 更新抽卡记录
     * @param arkAccount ark账号
     * @param channelId 渠道id
     * @return ResponseResult：是否成功
     */
    @GetMapping("/update")
    @Operation(operationId = "updateGacha", summary = "更新抽卡记录", description = "插入新的抽卡记录，不会覆盖以前的")
    @Parameters({
            @Parameter(name = "arkAccount", description = "ark账号", example = "13809041524"),
            @Parameter(name = "channelId", description = "渠道id", example = "1")
    })
    public ResponseResult<String> updateGacha(@NotBlank String arkAccount, @NotBlank Integer channelId) {
        arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功");
    }
}
