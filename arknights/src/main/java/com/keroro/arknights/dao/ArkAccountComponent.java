package com.keroro.arknights.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keroro.arknights.dao.mapper.ArkAccountMapper;
import com.keroro.arknights.dao.po.ArkAccount;
import org.springframework.stereotype.Component;

/**
 * @author wangpeng
 * @since 2023年12月28日 15:56
 */
@Component
public class ArkAccountComponent extends ServiceImpl<ArkAccountMapper, ArkAccount> {
}
