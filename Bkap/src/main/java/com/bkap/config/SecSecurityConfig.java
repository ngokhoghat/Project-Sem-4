package com.bkap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/dist/**", "/plugins/**", "/client/**", "/upload", "/uploads", "/files/**", "/file/**").permitAll()
		.antMatchers("/", "/home/**", "/product/**", "/api/**", "/blog", "/blog-detail").permitAll()
		.antMatchers("/cart", "/checkout", "/contact", "/product-detail").permitAll()
		.antMatchers("/admin/**").permitAll()
		.anyRequest().fullyAuthenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/admin").and().httpBasic();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setUserDetailsService(myUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());

		return provider;
	}
}