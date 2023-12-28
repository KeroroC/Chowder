package com.keroro.arknights.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keroro.arknights.dao.mapper.GachaRecordMapper;
import com.keroro.arknights.dao.po.GachaRecord;
import org.springframework.stereotype.Component;

/**
 * @author wangpeng
 * @since 2023年12月28日 16:06
 */
@Component
public class GachaRecordComponent extends ServiceImpl<GachaRecordMapper, GachaRecord> {
}
