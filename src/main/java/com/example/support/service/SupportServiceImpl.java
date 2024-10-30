package com.example.support.service;

import com.example.support.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.example.support.model.Support;

@Service
public class SupportServiceImpl implements SupportService {

    private final WebClient webClient;
    SupportRepository supportRepository;

    @Autowired
    public SupportServiceImpl(WebClient.Builder webClientBuilder, SupportRepository supportRepository) {
        this.webClient = webClientBuilder.baseUrl("https://dummyjson.com").build();
        this.supportRepository = supportRepository;
    }

    @Override
    public Mono<String> getExampleData() {

        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Support persistSupport(){
        Support support = new Support(12345L, "test");
        return supportRepository.save(support);
    }

}
