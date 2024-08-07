package com.example.spring.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin( f -> f.defaultSuccessUrl("/main", true) );
        http
                .authorizeRequests().anyRequest().authenticated();


        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SCryptPasswordEncoder scryptPasswordEncoder() {
        int cpuCost = (int) Math.pow(2, 14); // CPU 비용 파라미터 (N)
        int memoryCost = 8; // 메모리 비용 파라미터 (r)
        int parallelization = 1; // 병렬화 파라미터 (p)
        int keyLength = 32; // 키 길이
        int saltLength = 16; // 솔트 길이

        return new SCryptPasswordEncoder(cpuCost, memoryCost, parallelization, keyLength, saltLength);
    }

}
