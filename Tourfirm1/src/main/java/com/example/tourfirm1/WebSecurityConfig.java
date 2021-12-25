package com.example.tourfirm1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("Tour")
                .password("1234")
                .roles("TOURFIRM");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/TraveagencyTravels","/TraveagencyTravels/tour/create","/tour/delete/**","TraveagencyTravels/tour/**").hasRole("TOURFIRM")

                .antMatchers("Travels","Tourinfo").permitAll()
                .and().formLogin()
                .and().csrf().disable();
    }
    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
