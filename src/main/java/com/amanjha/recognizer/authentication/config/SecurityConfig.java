package com.amanjha.recognizer.authentication.config;

import com.amanjha.recognizer.models.Roles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
            ServerHttpSecurity http) {
        return http.authorizeExchange()
                .anyExchange().authenticated()
                .and().build();
    }

  /*  @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password(configurePasswordEncoder().encode("password"))
                .roles(Roles.USER)
                .build();
        return new MapReactiveUserDetailsService(user);
    }*/

    @Bean
    public PasswordEncoder configurePasswordEncoder(@Value("${security.encryption.secret}") String secret) {
        return new Pbkdf2PasswordEncoder(secret);
    }
}
