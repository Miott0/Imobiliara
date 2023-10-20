package com.imobiliaria.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControllerView {
    
    @GetMapping("/login")
    public ModelAndView home(){
        ModelAndView mdv = new ModelAndView();
        mdv.setViewName("login");
        return mdv;
    }
}
