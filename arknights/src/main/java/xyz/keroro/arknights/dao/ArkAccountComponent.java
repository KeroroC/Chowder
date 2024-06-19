package xyz.keroro.arknights.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import xyz.keroro.arknights.dao.mapper.ArkAccountMapper;
import xyz.keroro.arknights.dao.po.ArkAccount;

/**
 * @author wangpeng
 * @since 2023年12月28日 15:56
 */
@Component
public class ArkAccountComponent extends ServiceImpl<ArkAccountMapper, ArkAccount> {
}
