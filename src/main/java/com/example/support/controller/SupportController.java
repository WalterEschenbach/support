package com.example.support.controller;

import com.example.support.model.Support;
import com.example.support.service.SupportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class SupportController {

    @Autowired
    SupportServiceImpl supportService;


    @GetMapping("/data")
    public Mono<String> getData() {
        return supportService.getExampleData();
    }

    @PostMapping("/persist")
    public Support persistSupport(){
        return supportService.persistSupport();
    }

}
