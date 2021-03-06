package com.powertrader.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Piotr Dzierżęga on 2015-12-28.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8383");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, X-Auth-Token, Authorization,X-XSRF-TOKEN");
        response.setHeader("Access-Control-Expose-Headers","set-cookie, Set-Cookie, SET-COOKIE");
        response.setHeader("Access-Control-Max-Age", "3600");
       if(!request.getMethod().equalsIgnoreCase("OPTIONS")){
           chain.doFilter(req,res);
       }else{

       }
//        if (request.getMethod()!="OPTIONS") {
//            chain.doFilter(req, res);
//        } else {
//        }
    }

   public  void init(FilterConfig filterConfig) {}

   public void destroy() {}

}