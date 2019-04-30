package com.wellsfargo.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	 @Autowired
//	    PasswordEncoder passwordEncoder;
//	@Autowired
//	CustomSuccessHandler customSuccessHandler;
//
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("bill").password(passwordEncoder.encode("123456")).roles("USER");
//		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN");
//		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("dba").password(passwordEncoder.encode("123456")).roles("ADMIN","DBA");
//	
//	
//	}
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
// 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	  http.authorizeRequests()
//	  	.antMatchers("/", "/home").access("hasRole('USER')")
//	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
//	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
//	  	.usernameParameter("ssoId").passwordParameter("password")
//	  	.and().csrf()
//	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
//	}

}
