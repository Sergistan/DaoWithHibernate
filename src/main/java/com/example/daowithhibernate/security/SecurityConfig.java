package com.example.daowithhibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Sergey")
                .password(passwordEncoder().encode("password1"))
                .authorities("read","write")
                .and()
                .withUser("Ilya")
                .password(passwordEncoder().encode("password2"))
                .authorities("read")
                .and()
                .withUser("Alina")
                .password(passwordEncoder().encode("password3"))
                .authorities("write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-surname").hasAuthority("write");
    }
}
