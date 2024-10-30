package com.example.support.service;

import com.example.support.model.Support;
import reactor.core.publisher.Mono;

public interface SupportService {
    Mono<String> getExampleData();

    Support persistSupport();
}
