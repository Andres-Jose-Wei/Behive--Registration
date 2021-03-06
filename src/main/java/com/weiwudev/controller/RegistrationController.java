package com.weiwudev.controller;

import com.weiwudev.models.ResponseObject;
import com.weiwudev.models.User;
import com.weiwudev.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class RegistrationController {

    RegistrationService registrationService;

    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseObject>> registerUser(@RequestBody User user){

        return registrationService.registerUser(user).flatMap(data -> Mono.just(ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(data)))).onErrorReturn(
                ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseObject("error creating account, username may already exist")));
    }
    @PostMapping("/check")
    public Mono<String> check(@RequestBody User user){
        return Mono.just("Worked");
    }
}
