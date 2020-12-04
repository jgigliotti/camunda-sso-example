package com.example.workflow.config;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.rest.security.auth.AuthenticationResult;
import org.camunda.bpm.engine.rest.security.auth.impl.ContainerBasedAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationProvider extends ContainerBasedAuthenticationProvider {
    public static final String AUTHENTICATED_USER = "demo";
    public static final String ADMIN_GROUP = "camunda-admin";

    @Override
    public AuthenticationResult extractAuthenticatedUser(HttpServletRequest request, ProcessEngine engine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return AuthenticationResult.unsuccessful();
        }

        AuthenticationResult authenticationResult = new AuthenticationResult(AUTHENTICATED_USER, true);

        List<String> groups = new ArrayList<>();
        groups.add(ADMIN_GROUP);
        authenticationResult.setGroups(groups);

        return authenticationResult;
    }
}
