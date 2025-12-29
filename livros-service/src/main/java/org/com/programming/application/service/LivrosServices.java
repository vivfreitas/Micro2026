package org.com.programming.application.service;

import org.com.programming.application.entities.LivrosEntity;
import org.com.programming.application.repositories.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivrosServices {

    private final LivrosRepository livrosRepository;

    public LivrosServices(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }


    public List<LivrosEntity> listLivros(){
        List<LivrosEntity> testObj = new ArrayList<>();
        testObj.add(new LivrosEntity("A empregada"));
        testObj.add(new LivrosEntity("Mindset"));
        livrosRepository.saveAll(testObj);

        return livrosRepository.findAll();
    }
}
