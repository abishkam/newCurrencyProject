package com.example.currencyproject.controller;

import com.example.currencyproject.model.Men;
import com.example.currencyproject.model.MenJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Set;

@Controller
@SessionAttributes("name")
public class SecurityController {

    @Autowired
    MenJpa menJpa;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/registration")
    public String reg(@RequestParam("id") long id,
                      @RequestParam("name") String name,
                      @RequestParam("password") String password,
                      @RequestParam("role") String role){
        menJpa.save(new Men(id, name, password, role));
        return "redirect:/curr";
    }
}
