package com.knk.refrigerator_manager.Config;

import com.knk.refrigerator_manager.jwt.JwtAccessDeniedHandler;
import com.knk.refrigerator_manager.jwt.JwtAuthenticationEntryPoint;
import com.knk.refrigerator_manager.jwt.TokenProvider;
import com.knk.refrigerator_manager.user.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableWebSecurity
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private final CustomUserDetailsService customUserDetailsService;
    @Autowired
    private final UserService userService;

//
    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();
        http.headers().frameOptions().disable(); //sameOrigin()*********
        http.exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler);
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/registerUser", "/*", "/auth/**").permitAll()
                .requestMatchers("/user/user").hasRole("USER")
                .requestMatchers("/admin/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.formLogin().loginProcessingUrl("/login")
//                .permitAll();
        http.apply(new JwtSecurityConfig(tokenProvider));
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, CustomUserDetailsService customUserDetailsService) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()).and().build();
    }
//    @Bean
//    public AuthenticationManager configure(AuthenticationManagerBuilder auth) throws Exception {
//        return auth
//                .userDetailsService(customUserDetailsService)
//                .passwordEncoder(getPasswordEncoder()).and().build();
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}