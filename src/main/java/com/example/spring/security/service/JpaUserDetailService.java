package com.example.spring.security.service;

import com.example.spring.security.entities.User;
import com.example.spring.security.model.CustomUserDetails;
import com.example.spring.security.repositories.UserRepository;
import io.micrometer.observation.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

        User user = userRepository.findUserByUsername(username).orElseThrow(s);

        return new CustomUserDetails(user);
    }
}
