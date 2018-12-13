package cnpm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;

import cnpm.service.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	@Autowired
    @Transactional
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
		
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
//                withUser("kai").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
//        Kai 123456  sena 123456
    }
	public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/","/index", "/errors", "/introduce", "/register", "/search", "/seeNews",   "/login", "/logout").permitAll();
        
     // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/manage-account/profile", "/postNews").access("hasAnyRole('USER', 'ADMIN')");
        
		// Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
//		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/admin/**", "/list-account").hasAnyAuthority("ADMIN");

		// Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn
		// /user/**
//		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
		http.authorizeRequests().antMatchers("/user/**","/manage-account", "/manage-account/profile", "/manage-account/manage-posts", "/postNews").hasAnyAuthority("ADMIN", "USER");

		// Khi người dùng đã login, với vai trò USER, Nhưng truy cập vào trang
		// yêu cầu vai trò ADMIN, sẽ chuyển hướng tới trang /403
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
				.loginProcessingUrl("/j_spring_security_login")//
				.loginPage("/login")//
//				.defaultSuccessUrl("/user")//
				.defaultSuccessUrl("/manage-account/profile")//
				.failureUrl("/login?message=error")//
				.usernameParameter("username")//
				.passwordParameter("password")
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

	}
}
