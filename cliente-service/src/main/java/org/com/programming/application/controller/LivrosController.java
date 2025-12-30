package org.com.programming.application.controller;

import org.com.programming.application.feign.LivrosClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/teste")
public class LivrosController {
    private final LivrosClient livrosClient;
    public LivrosController(LivrosClient livrosClient){
        this.livrosClient = livrosClient;
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Object>> teste(){
        List<Object> obj = livrosClient.obterLivrosParaCliente();
        return ResponseEntity.ok(obj);
    }
}
