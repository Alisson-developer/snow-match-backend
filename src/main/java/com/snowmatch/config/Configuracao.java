package com.snowmatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configuracao {


    @Bean
    public SecurityFilterChain filtroSeguranca(HttpSecurity httpSecurity) throws Exception {
        final String PATH_ROLE = "/usuario/**";
        final String ROLE = "USUARIO";
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(
                        autorize -> autorize
                                .requestMatchers(HttpMethod.POST, PATH_ROLE).hasRole(ROLE)
                                .requestMatchers(HttpMethod.GET, PATH_ROLE).hasRole(ROLE)
                                .requestMatchers(HttpMethod.PUT, PATH_ROLE).hasRole(ROLE)
                                .requestMatchers(HttpMethod.DELETE, PATH_ROLE).hasRole(ROLE)
                                .anyRequest().authenticated()
                )
                .build();
    }

}
