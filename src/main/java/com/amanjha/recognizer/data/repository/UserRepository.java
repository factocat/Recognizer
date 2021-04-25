package com.amanjha.recognizer.data.repository;

import com.amanjha.recognizer.models.ApplicationUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<ApplicationUser, String> {
    Mono<ApplicationUser> findByCredentialsUsername(String username);
}
