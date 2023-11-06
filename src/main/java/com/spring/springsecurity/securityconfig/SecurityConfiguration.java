package com.spring.springsecurity.securityconfig;

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
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("ahmed").password(passwordEncoder().encode("ahmed123")).roles("ADMIN")
                .authorities("ACCESS_BASIC1")
                .and()
                .withUser("yasser").password(passwordEncoder().encode("yasser123")).roles("MANGER")
                .authorities("ACCESS_BASIC2")
                .and()
                .withUser("karim").password(passwordEncoder().encode("karim123")).roles("USER");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/main").permitAll()
                .antMatchers("/api/profile").authenticated()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/basic/**").hasAuthority("ACCESS_BASIC1")
                .antMatchers("/api/manage").hasAnyRole("ADMIN" , "MANGER")
//                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
