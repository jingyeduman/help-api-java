package com.miaoshou.helpapijava.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoshou.helpapijava.interceptor.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("/user/login").permitAll();
            requests.anyRequest().authenticated();
        });
        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        });

        http.securityContext((content) -> {
            content.securityContextRepository(new HttpSessionSecurityContextRepository());
        });

        http.addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling((exceptionHandlingCustomizer) -> {
            exceptionHandlingCustomizer.authenticationEntryPoint((request, response, authException) -> {
                ObjectMapper objectMapper = new ObjectMapper();
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                PrintWriter writer = response.getWriter();
                writer.write("{code: 5001}");
            });
        });

        return http.build();
    }




}
