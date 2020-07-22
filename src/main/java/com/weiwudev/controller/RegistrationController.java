package com.weiwudev.controller;

import com.weiwudev.models.User;
import com.weiwudev.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class RegistrationController {

    RegistrationService registrationService;

    @PostMapping("/register")
    public Mono<String> registerUser(@RequestBody User user){
        return registrationService.registerUser(user);
    }

}
