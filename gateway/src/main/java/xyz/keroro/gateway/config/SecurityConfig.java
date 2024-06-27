package xyz.keroro.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author wangpeng
 * @since 2024年06月20日 下午4:42
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 用户数据的数据源，可以是内存，jdbc数据库或者自己实现
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        manager.createUser(User.withUsername("user").password(encoder.encode("password")).roles("USER").build());
        return new ChowderUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 取消spring-security自己的登录/登出页面
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                // 禁用csrf保护，前后端分离不需要
                .csrf(AbstractHttpConfigurer::disable)
                // 禁用session，使用JWT
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 禁用httpBasic，因为我们传输数据用的是post，而且请求体是JSON
                .httpBasic(AbstractHttpConfigurer::disable)
                // 开放登录接口，其余均要认证
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/login", "/test", "/user/add").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}
