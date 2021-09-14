package com.example.todolist.configurations;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = "com.example.todolist")
public class AppConfig implements WebMvcConfigurer{

    @Bean
    public ViewResolver viewResolver() {
 
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
    
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
    	final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("EmailThread-");
        executor.initialize();
		return executor;
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
    }
}
