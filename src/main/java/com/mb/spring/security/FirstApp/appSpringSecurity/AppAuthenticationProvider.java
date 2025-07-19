package com.mb.spring.security.FirstApp.appSpringSecurity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider {

    /*
    Get username and password from login
    Validate credentials
    if validated return with UsernamePasswordAuthenticationToken
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String credentials = authentication.getCredentials().toString();
        if("Mohit".equals(userName) && "Banyal".equals(credentials)){
            return new UsernamePasswordAuthenticationToken(userName,credentials, Arrays.asList());
        }
        else {
            throw new BadCredentialsException("Invalid Username or password");
        }
    }

    /*
    Method validate UsernamePasswordAuthenticationToken in between
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
