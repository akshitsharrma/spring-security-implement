package com.springsecurity.app.security;

import com.springsecurity.app.securityFilter.MySecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig {
//    @Bean
//    UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Akshit")
//                .password(passwordEncoder().encode("springSecurity"))
//                .authorities("read").build();
//        userDetailsService.createUser(user);
//        return  userDetailsService;
//    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //default will be overridden with filterChain Method
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //for basicAuth
        http.httpBasic(Customizer.withDefaults());

        //for formBased login
        //http.formLogin(Customizer.withDefaults());

        //can access any request if authorized
        //http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());

        //can't access any request apart from /hello if authorized
        http.authorizeHttpRequests
                (auth -> auth
                        .requestMatchers("/hello")
                        .authenticated().anyRequest().denyAll());
        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
