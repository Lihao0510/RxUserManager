package com.lihao.nimatest.Servlet;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lihao on 2016/12/10.
 */
public class RequestFilter implements Filter{

    private FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    public void destroy() {
        this.config = null;
    }
}
