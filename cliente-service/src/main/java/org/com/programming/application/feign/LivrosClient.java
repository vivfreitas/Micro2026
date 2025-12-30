package org.com.programming.application.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@FeignClient(value = "livros-service")
public interface LivrosClient {

    @GetMapping("/teste/listas")
    List<Object> obterLivrosParaCliente();
}
