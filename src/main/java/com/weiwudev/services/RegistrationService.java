package com.weiwudev.services;

import com.weiwudev.models.User;
import reactor.core.publisher.Mono;

public interface RegistrationService {
    Mono<String> registerUser(User user);
}
