package com.user_auth_v1.config;

import com.user_auth_v1.interceptors.AppInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages =  "com.user_auth_v1")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // DEFAULT RESOURCE REGISTRY:
        registry
                .addResourceHandler("css/**", "images/**", "js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/images/", "classpath:/static/js/" );

        registry
                .addResourceHandler("app/css/**", "app/images/**", "app/js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/images/", "classpath:/static/js/" );


    }// END OF ADD RESOURCE HANDLER.

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/Views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }// END OF VIEW RESOLVER METHOD.


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInterceptor()).addPathPatterns("/app/*");
    }// END OF ADD INTERCEPTORS METHOD.

}// END OF APPLICATION CONFIG CLASS.
