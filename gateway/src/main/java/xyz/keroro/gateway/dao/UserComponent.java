package xyz.keroro.gateway.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import xyz.keroro.gateway.dao.mapper.UserMapper;
import xyz.keroro.gateway.dao.po.User;

/**
 * @author wangpeng
 * @since 2024年06月21日 上午11:11
 */
@Component
public class UserComponent extends ServiceImpl<UserMapper, User> {
}
