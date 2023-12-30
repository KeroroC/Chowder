package com.keroro.arknights.controller;

import com.keroro.arknights.service.ArkGachaService;
import com.keroro.common.response.ResponseResult;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeng
 * @since 2023年12月29日 22:57
 */
@RestController
@RequestMapping("/gacha")
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
    public ResponseResult<String> updateGacha(@NotBlank String arkAccount, @NotBlank Integer channelId) {
        arkGachaService.updateGacha(arkAccount, channelId);
        return ResponseResult.success("更新成功");
    }
}
