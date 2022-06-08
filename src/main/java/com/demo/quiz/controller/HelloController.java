package com.demo.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.components.AuthenticationFacade;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor( onConstructor = @__(@Autowired))
public class HelloController {

    private final AuthenticationFacade authenticationFacade;

    @GetMapping(value = "/greetings")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok().body("Hello " + authenticationFacade.getAuthenticationInfo().getName() + "!");
    }

}
