package com.powertrader.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Luke on 29.12.2015.
 */
@RestController
public class AuthController {

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/token")
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

//    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
//    public String logout() {
//        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
//
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        return "logged out";
//    }

}
