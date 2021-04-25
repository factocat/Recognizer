package com.amanjha.recognizer.data;

import com.amanjha.recognizer.data.repository.UserRepository;
import com.amanjha.recognizer.models.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsPasswordService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public class UserDetailsService implements ReactiveUserDetailsService, ReactiveUserDetailsPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDetails> updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<ApplicationUser> user = userRepository.findByCredentialsUsername(username);
        return user.map(e -> User.builder().username(username).password(e.getCredentials().getPassword()).credentialsExpired(false).accountLocked(false).build());
    }
}
