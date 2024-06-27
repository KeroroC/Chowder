package xyz.keroro.gateway.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 只需要实现UserDetailsService即可，不需要UserDetailsManager
 * @author wangpeng
 * @since 2024年06月20日 下午10:20
 */
public class ChowderUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
