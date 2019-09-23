package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityAppConfig extends WebSecurityConfigurerAdapter{
	
	private static final String UNAME_QUERY="SELECT UNAME,PWD,STATUS FROM AERO_USERS WHERE UNAME=?";
	private static final String ROLE_QUERY="SELECT ROLE_ID,ROLE_NAME,UNAME FROM AERO_ROLES WHERE UNAME=?";
	
	@Autowired
	private DataSource ds;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index.jsp").access("permitAll").
		              antMatchers("/status.htm").access("hasAnyRole('ROLE_PASSENGER','ROLE_CAPTAIN')")
		              .and().formLogin().and().logout().logoutSuccessUrl("/index.jsp").deleteCookies("JSESSIONID").invalidateHttpSession(true).and().exceptionHandling().accessDeniedPage("/access_denied.jsp").and().
		              rememberMe().and().sessionManagement().invalidSessionUrl("/invalid.jsp").maximumSessions(2).maxSessionsPreventsLogin(true).expiredUrl("/max_sessions.jsp");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).
		      usersByUsernameQuery(UNAME_QUERY).authoritiesByUsernameQuery(ROLE_QUERY);
	}
	
}
