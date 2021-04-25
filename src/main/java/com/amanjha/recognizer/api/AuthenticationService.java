package com.amanjha.recognizer.api;

import com.amanjha.recognizer.models.AuthenticationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/authenticate")
public class AuthenticationService {

    @PostMapping
    public Mono<String> authenticate(){
        return Mono.justOrEmpty("<h1>Hello, World!! </h1>");
    }
}
