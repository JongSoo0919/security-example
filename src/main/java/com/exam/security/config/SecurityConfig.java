package com.exam.security.config;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers((header) -> header.frameOptions((frameOption) -> frameOption.sameOrigin()))
                .csrf((csrf) -> csrf.disable()).cors((cors) -> cors.disable())
                .authorizeHttpRequests((request) -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/status")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/view/join")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/join")).permitAll()
                        .anyRequest().authenticated()
                ).formLogin((login) -> login
                        .loginPage("/view/login").permitAll()
                        .usernameParameter("userId")
                        .passwordParameter("password")
                        .loginProcessingUrl("/api/login").permitAll()
                        .defaultSuccessUrl("/view/dashboard", true).permitAll()
                ).logout((logout) -> Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
