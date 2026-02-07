//package com.catering.catering_hub.configs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // Disable CSRF for JWT-based stateless APIs
//                .csrf(csrf -> csrf.disable())
//
//                // Configure HTTP request authorization
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/authenticate", "/cater/register/user").permitAll()  // Allow these paths without authentication
//                                .anyRequest().authenticated()  // All other paths require authentication
//                )
//
//                // Configure stateless behavior for JWT
//                .securityContext(securityContext ->
//                        securityContext.requireExplicitSave(false) // Ensures the security context isn't saved for stateless APIs
//                )
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session management for stateless authentication
//                );
//
//        return http.build();  // Return the configured SecurityFilterChain
//    }
//}
