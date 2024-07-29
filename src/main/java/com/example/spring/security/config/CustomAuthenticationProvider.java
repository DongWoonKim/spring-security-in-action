package com.example.spring.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
public class CustomAuthenticationProvider /*implements AuthenticationProvider*/ {

//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        if (passwordEncoder.matches(password, userDetails.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        }
//
//        throw new BadCredentialsException("Something went wrong");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }


//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        // 인증 논리를 추가할 위치
//        String username = authentication.getName();
//        String password = String.valueOf(authentication.getCredentials());
//
//        if ("john".equals(username) && "12345".equals(password)) {
//            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
//        } else {
//            throw new AuthenticationCredentialsNotFoundException("Error!");
//        }
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        // Authentication 형식의 구현을 추가할 위치
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
}
