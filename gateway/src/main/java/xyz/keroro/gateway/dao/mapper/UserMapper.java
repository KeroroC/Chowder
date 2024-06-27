package xyz.keroro.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.keroro.gateway.dao.po.User;

/**
 * @author wangpeng
 * @since 2024年06月21日 上午11:10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
