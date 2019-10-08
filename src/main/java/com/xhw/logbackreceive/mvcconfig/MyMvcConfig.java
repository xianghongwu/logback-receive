package com.xhw.logbackreceive.mvcconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: xhw
 * @Date: 2019-09-25 10:55
 * @Description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/directory");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String projectUrl = System.getProperty("user.dir");
        System.out.println("projectUrl:"+projectUrl+"++++++++++++++++++");
        registry.addResourceHandler("/logs/**").addResourceLocations("file:"+projectUrl+"/logs/");
    }
}
