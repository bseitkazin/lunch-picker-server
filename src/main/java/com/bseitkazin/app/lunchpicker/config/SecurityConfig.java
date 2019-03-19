package com.bseitkazin.app.lunchpicker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static String NAME = "application";
	private static String PSWD = "application-password";
	private static String ROLE = "USER";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser(NAME)
				.password(passwordEncoder().encode(PSWD))
				.roles(ROLE);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.requestMatchers()
			.antMatchers("/oauth/token")
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.disable();
	}
	
	@Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
