package com.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailService = new InMemoryUserDetailsManager();

        var user = User.withUsername("john")
                .password("12345")
                .roles("USER")
                .build();

        userDetailService.createUser( user );

        return userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder를 사용하는 경우
//        return new BCryptPasswordEncoder();

        // 또는 비밀번호 암호화를 사용하지 않으려면 다음을 사용.
         return NoOpPasswordEncoder.getInstance();
    }

}
