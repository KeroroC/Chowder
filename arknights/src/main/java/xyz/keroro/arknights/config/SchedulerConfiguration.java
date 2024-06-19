package xyz.keroro.arknights.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 调度器配置
 * 可实现SchedulingConfigurer接口进行自定义配置，例如线程池大小等
 * @author wangpeng
 * @since 2024年01月03日 20:22
 */
@Configuration
@EnableScheduling
public class SchedulerConfiguration {
}
