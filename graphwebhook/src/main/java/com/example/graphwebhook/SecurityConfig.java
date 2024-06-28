// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.example.graphwebhook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import com.azure.spring.cloud.autoconfigure.implementation.aad.security.AadWebApplicationHttpSecurityConfigurer;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${app.protect.authenticated}")
    private String[] protectedRoutes;

    @SuppressWarnings("removal")
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.securityContext(context -> context.requireExplicitSave(false))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/listen"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(protectedRoutes)
                        .authenticated().anyRequest().permitAll())
                .apply(AadWebApplicationHttpSecurityConfigurer.aadWebApplication());

        return http.build();
    }
}
