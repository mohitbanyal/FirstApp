package com.mb.spring.security.FirstApp.appSpringSecurity;

import jakarta.servlet.*;

import java.io.IOException;

public class AppSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before Custom Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After Custom Filter");
    }
}
