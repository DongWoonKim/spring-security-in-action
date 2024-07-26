package com.example.spring.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final CustomAuthenticationProvider authenticationProvider;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults());
//
//        http.authenticationProvider(authenticationProvider);
//
//        return http.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails u = new User("john", "12345", "read");
//        List<UserDetails> users = List.of(u);
//        return new InMemoryUserDetailsService(users);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        String usersByUsernameQuery = "select username, password, enabled from spring_security.users where username = ?";
        String authsByUserQuery = "select username, authority from spring_security.authorities where username = ?";

        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);

        return userDetailsManager;

//        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
