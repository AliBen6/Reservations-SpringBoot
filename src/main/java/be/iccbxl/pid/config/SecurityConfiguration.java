package be.iccbxl.pid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable();
		http.authorizeRequests()
				.antMatchers("/login", "/register", "/process_register", "/h2-console/**", "/home**",
						"/representations**", "/shows**")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/representationsPaginated", true).permitAll().and().logout().permitAll();
	}

	@Bean
	public AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider impl = new DaoAuthenticationProvider();
		impl.setUserDetailsService(userDetailsService);
		impl.setPasswordEncoder(passwordEncoder());
		impl.setHideUserNotFoundExceptions(false);
		return impl;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.authenticationProvider(daoAuthenticationProvider());
	}
}
