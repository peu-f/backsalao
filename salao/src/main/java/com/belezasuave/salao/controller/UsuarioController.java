package com.belezasuave.salao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @GetMapping
    public String start(){
        return "Pagina de boas vindas";
    }


    @GetMapping("/login")
    public String login(){
        return "pagina de login";
    }

}
