package com.noname.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    @Bean
    @Qualifier(value = "internalRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .requestFactory((settings) -> new BufferingClientHttpRequestFactory(
                        ClientHttpRequestFactories.get(HttpComponentsClientHttpRequestFactory.class, settings)))
                .setConnectTimeout(Duration.ofSeconds(300))
                .setReadTimeout(Duration.ofSeconds(300))
                .build();
    }
}
