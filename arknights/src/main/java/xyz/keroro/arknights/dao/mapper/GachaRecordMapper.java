package xyz.keroro.arknights.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.keroro.arknights.dao.po.GachaRecord;

/**
 * 抽卡记录mapper
 * @author wangpeng
 * @since 2023年06月19日 17:23
 */
@Mapper
public interface GachaRecordMapper extends BaseMapper<GachaRecord> {}
