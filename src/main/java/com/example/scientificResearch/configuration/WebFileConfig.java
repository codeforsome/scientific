package com.example.scientificResearch.configuration;
import org.springframework.context.annotation.Configuration;import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//本地的绝对路径加到静态资源路径里，作为资源服务器使用
@Configuration
public class WebFileConfig  extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/public/thesis/**").addResourceLocations("file:G:\\scientific\\thesis\\");
        registry.addResourceHandler("/public/img/**").addResourceLocations("file:G:\\scientific\\img\\");
        super.addResourceHandlers(registry);
    }
}
