package org.zzy.spring4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-19
 * @sine 1.0
 */
@Configuration
@ComponentScan(
        basePackages = {"org.zzy.spring4"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
/*@EnableScheduling
@EnableAsync*/
@ImportResource(locations = {"classpath:application-context/service/task.xml"})
public class RootConfig {
}
