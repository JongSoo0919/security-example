package com.exam.security.config;

import com.exam.security.filter.JwtAuthenticationFilter;
import com.exam.security.util.jwt.JwtTokenProvider;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers((header) -> header.frameOptions((frameOption) -> frameOption.sameOrigin()))
                .csrf((csrf) -> csrf.disable()).cors((cors) -> cors.disable())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // jwt 토큰을 이용할 것이므로 stateless
                .authorizeHttpRequests((request) -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/status")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/view/join")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/join")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/view/admin/**")).hasRole("ADMIN")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/view/user/**")).hasRole("USER")
                        .anyRequest().authenticated()
                ).formLogin((login) -> login
                        .loginPage("/view/login").permitAll()
                        .usernameParameter("userId")
                        .passwordParameter("password")
                        .loginProcessingUrl("/api/login").permitAll()
                        .defaultSuccessUrl("/view/dashboard", true).permitAll()
                ).logout((logout) -> Customizer.withDefaults())
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
