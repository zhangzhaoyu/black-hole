package org.zzy.spring4.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-19
 * @sine 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.zzy.spring4.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver =
                new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        /*ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/messages");*/
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }



    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
