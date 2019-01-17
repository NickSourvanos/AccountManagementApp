package com.dataverse.AccountManagementApp;

import com.dataverse.AccountManagementApp.security.LoginSuccessHandler;
import com.dataverse.AccountManagementApp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity auth) throws Exception {
        auth
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("pass")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/registration").anonymous()
                .antMatchers("/success").anonymous()
                .antMatchers("/**").hasAuthority("USER")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
        ;
    }


}
