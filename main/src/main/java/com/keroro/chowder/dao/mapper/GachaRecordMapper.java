package com.keroro.chowder.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keroro.chowder.dao.po.GachaRecordPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 抽卡记录mapper
 * @author: wangpeng
 * @date: 2023年06月19日 17:23
 */
@Mapper
public interface GachaRecordMapper extends BaseMapper<GachaRecordPO> {
}
