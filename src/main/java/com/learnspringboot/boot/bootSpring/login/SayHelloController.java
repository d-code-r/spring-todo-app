package com.learnspringboot.boot.bootSpring.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Security;

@Controller
@SessionAttributes("name")
public class SayHelloController {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoSayHelloPage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "sayHello";
    }
    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}