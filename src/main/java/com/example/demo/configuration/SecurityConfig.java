package com.example.demo.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests((requests) -> requests
				.antMatchers("/admin/**","/inicio/**").hasRole("administrador").antMatchers("/alumno/**","/inicio/**").hasRole("alumno").antMatchers("/profesor/**","/inicio/**").hasRole("profesor").antMatchers( "/","/webjars/**","/imgs/**","/css/**","/auth/**","/inicio/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/auth/login").usernameParameter("email")
				.defaultSuccessUrl("/inicio/")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll().
					logoutUrl("/logout").logoutSuccessUrl("/auth/login?logout"));

		return http.build();
	}
	
	@Bean 
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
}