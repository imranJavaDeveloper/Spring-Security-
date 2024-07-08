package com.furkan.SpringSecurityProject.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.plaf.PanelUI;

@Configuration
@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/public ***").permitAll()
                  .antMatchers("/public **").hasRole("NORMAL")
                  .antMatchers("/users ***").hasRole("ADMIN")
                  .anyRequest()
                   .authenticated().
                    and()
                   .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("frukan").password("frukan@123").roles("NORMAL");
//
        auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("john123")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("furkan").password(this.passwordEncoder().encode("furkan123")).roles("NORMAL");
    }
@Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
