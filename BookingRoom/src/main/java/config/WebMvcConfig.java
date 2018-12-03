package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@EnableAutoConfiguration
@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
  
  
   // Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..)
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
       registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
   }
   @Override
   
   public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/index").setViewName("home");
       registry.addViewController("/").setViewName("home");
       registry.addViewController("/register").setViewName("register");
       registry.addViewController("/login").setViewName("login");
       registry.addViewController("/search").setViewName("search");
   }
    
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
 
}