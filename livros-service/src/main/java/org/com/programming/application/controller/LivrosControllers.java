package org.com.programming.application.controller;

import org.com.programming.application.entities.LivrosEntity;
import org.com.programming.application.service.LivrosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class LivrosControllers {

    private final LivrosServices livrosServices;

    public LivrosControllers(LivrosServices livrosServices) {
        this.livrosServices = livrosServices;
    }

    @GetMapping("/listas")
    public ResponseEntity<List<LivrosEntity>> listagem(){
        return ResponseEntity.ok(livrosServices.listLivros());
    }
}
