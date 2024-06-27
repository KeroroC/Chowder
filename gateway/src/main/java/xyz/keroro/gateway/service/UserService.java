package xyz.keroro.gateway.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.keroro.gateway.dao.UserComponent;
import xyz.keroro.gateway.dao.po.User;

/**
 * 用户服务
 * @author wangpeng
 * @since 2024年06月21日 上午11:24
 */
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserComponent userComponent;

    public UserService(PasswordEncoder passwordEncoder, UserComponent userComponent) {
        this.passwordEncoder = passwordEncoder;
        this.userComponent = userComponent;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnable(true);
        return userComponent.save(user);
    }
}
