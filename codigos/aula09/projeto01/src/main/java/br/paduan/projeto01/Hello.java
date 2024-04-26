package br.paduan.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    
    @GetMapping("/hello")
    public String helloWorld() {
        return "Boa noite meus amigos!";
    }

    @PostMapping("/hello")
    public String helloWorld2() {
        return "Boa noite via POST!";
    }
}
