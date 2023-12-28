package com.keroro.arknights.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keroro.arknights.dao.po.ArkAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * 抽卡记录mapper
 * @author wangpeng
 * @since 2023年06月19日 17:23
 */
@Mapper
public interface ArkAccountMapper extends BaseMapper<ArkAccount> {}
