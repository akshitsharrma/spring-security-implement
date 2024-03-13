package com.springsecurity.app.authenticationProvider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.BiPredicate;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        BiPredicate<String, String> validUser =
                (userName, passWord) -> "akshit".equals(userName) && "spring".equals(passWord);

        if (validUser.test(name, pwd)) {
            return new UsernamePasswordAuthenticationToken(name, pwd, Arrays.asList());
        } else {
            throw new BadCredentialsException("Username or password incorrect");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
