package cnpm.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("cnpm.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:application.properties")
public class ApplicationContextConfig { 
  
	 @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/html/");
	        resolver.setSuffix(".html");
	        return resolver;
	    }
	 @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
	        bean.addBasenames("classpath:messages.properties");
	        return bean;
	    }
}