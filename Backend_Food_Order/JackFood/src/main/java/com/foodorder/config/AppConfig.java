package com.foodorder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppConfig {

	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(Authorize -> Authorize
				.requestMatchers("/api/admin/**").hasAnyRole("RESTAURANT_OWNER","ADMIN")
				.requestMatchers("/api/**").authenticated()
				.anyRequest().permitAll()
				).addFilterBefore(new JwtTokenValidator, BasicAuthenticationFilter.class).csrf(csrf -> csrf.disable).cors(cors)
		
		
		
		
		
		return null;
	}

}
