package com.powertrader.web;

import com.powertrader.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dudus on 2016-01-06.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/")
    public String returnHello() {
        return "hello";
    }
}
