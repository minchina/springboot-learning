package org.ncmao.config;


import org.ncmao.filter.AccessTokenVerifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private AccessTokenVerifyInterceptor accessTokenVerifyInterceptor;



//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(accessTokenVerifyInterceptor).addPathPatterns("/sms/**");
//        super.addInterceptors(registry);
//    }
}

