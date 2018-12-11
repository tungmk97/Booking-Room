package cnpm.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories("cnpm.repository")
@EntityScan("cnpm.domain")
@ComponentScan({"cnpm.*"})

public class BookingRoomApplication extends SpringBootServletInitializer  {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BookingRoomApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(BookingRoomApplication.class, args);
	}
	
}
