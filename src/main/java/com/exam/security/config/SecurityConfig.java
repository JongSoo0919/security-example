package com.exam.security.config;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.disable()).cors((cors) -> cors.disable())
                .authorizeHttpRequests(
                        (request) -> request
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .anyRequest().authenticated())
                .formLogin(
                        (login) -> login
                                .loginPage("/view/login").permitAll()
                                .usernameParameter("email")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/view/dashboard", true))
                .logout(
                        Customizer.withDefaults()
                );

        return http.build();
    }
}
