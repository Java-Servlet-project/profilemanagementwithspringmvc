package com.profilemanagement.springconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.profilemanagement.controller")
@ComponentScan(basePackages = "com.profilemanagement.serviceimpl")
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	/*
	 * @Override public void configureDefaultServletHandling(final
	 * DefaultServletHandlerConfigurer configurer) { configurer.enable(); }
	 */
}
