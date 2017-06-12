package org.ncmao.config;


import org.ncmao.filter.AccessTokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AccessTokenVerifyInterceptor accessTokenVerifyInterceptor (){
        return new AccessTokenVerifyInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessTokenVerifyInterceptor()).addPathPatterns("/login");
        super.addInterceptors(registry);
    }
}
