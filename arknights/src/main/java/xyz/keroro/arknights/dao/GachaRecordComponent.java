package xyz.keroro.arknights.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import xyz.keroro.arknights.dao.mapper.GachaRecordMapper;
import xyz.keroro.arknights.dao.po.GachaRecord;

/**
 * @author wangpeng
 * @since 2023年12月28日 16:06
 */
@Component
public class GachaRecordComponent extends ServiceImpl<GachaRecordMapper, GachaRecord> {
}
