package com.demo.quiz.components;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {

    Authentication getAuthenticationInfo();

}