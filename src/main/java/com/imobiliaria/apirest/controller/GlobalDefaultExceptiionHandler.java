package com.imobiliaria.apirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class GlobalDefaultExceptiionHandler {

    @ExceptionHandler(Exception.class)
    public String errorException(Exception e, Model model){
        model.addAttribute("msgErros", e.getMessage());
        return "error";
    }
}