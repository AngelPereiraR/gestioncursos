package com.example.demo.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests((requests) -> requests
				.antMatchers("/admin/**").hasRole("administradores").antMatchers("/alumno/**").hasRole("alumnos").antMatchers("/profesor/**").hasRole("profesores").antMatchers( "/","/webjars/**","/css/**","/auth/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.defaultSuccessUrl("/inicio")
				.permitAll().loginPage("/login")
			)
			.logout((logout) -> logout.permitAll().
					logoutUrl("/logout").logoutSuccessUrl("/login?logout"));

		return http.build();
	}
	
	@Bean 
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
	
	/*
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Bean
	public UserDetails userDetailsService(String username)throws UsernameNotFoundException {
		com.example.demo.entity.User user = userRepository.finByUsername(username);
		
		UserBuilder builder=null;
		
		if(user!=null) {
			
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(user.getPassword());
			builder.authorities(new SimpleGrantedAuthority(user.getRole()));
		}else 
			throw new UsernameNotFoundException("User not found");
		return builder.build();
		
	}
	*/
}
