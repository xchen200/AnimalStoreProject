package com.xiaoyi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.xiaoyi.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin").hasAnyAuthority("admin")
                .antMatchers("/register").permitAll()
                .antMatchers("/animalDetail").permitAll()
                .antMatchers("/buy").permitAll()
                .antMatchers("/cart").permitAll()
                .antMatchers("/lessen").permitAll()
                .antMatchers("/delete").permitAll()
                .antMatchers("/save").permitAll()
                .antMatchers("/pay").permitAll()
                .antMatchers("/order").permitAll()
                .antMatchers("/adminLogin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login-processing")
                .loginPage("/login-page")
                .successHandler(loginSuccessHandler)
//                .defaultSuccessUrl("/login-success", false)
                .failureUrl("/authentication-failure")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/webapp/**", "/static/**", "/css/**", "/js/**", "/img/**",
                        "/authentication-failure/**");
    }
}
