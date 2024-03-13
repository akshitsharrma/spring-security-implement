package com.springsecurity.app.securityFilter;

import jakarta.servlet.*;

import java.io.IOException;

public class MySecurityFilter implements Filter {
    //receive the servlet incoming request which is the request
    //coming from the client
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Whatever you want to do with response before filter
        System.out.println("Before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After");
    }
}
