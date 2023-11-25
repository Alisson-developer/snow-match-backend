package com.snowmatch.config;

import com.snowmatch.anotacoes.SnowAutowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Configuracao {

    @SnowAutowired
    private SecurityFilter filtroDeSeguranca;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        final String PATH = "/usuario/**";
        final String ROLE_USER = "USER";
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        autorize -> autorize
                                .requestMatchers(HttpMethod.POST, "/error").permitAll()
                                .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/usuario/cadastrar").permitAll()
                                .requestMatchers(HttpMethod.GET, PATH).hasRole(ROLE_USER)
                                .requestMatchers(HttpMethod.PUT, PATH).hasRole(ROLE_USER)
                                .requestMatchers(HttpMethod.DELETE, PATH).hasRole(ROLE_USER)
                                .anyRequest().authenticated()
                )
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(filtroDeSeguranca, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
