package com.goeuro.esurovtsev.goeurotest.service;

import com.goeuro.esurovtsev.goeurotest.domain.Suggestion;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GoEuroApiClient {
    // Normally an app config service should be implemented which provides all config related values.
    // Here for simplicity we are directly injecting url from application.properties
    @Value("${application.suggestionUrlTemplate}")
    private String suggestionUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Suggestion> findSuggestionsByCity(@NonNull String city) {
        ResponseEntity<Suggestion[]> response =
                restTemplate.getForEntity(suggestionUrl, Suggestion[].class, ImmutableMap.of("city", city));

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException(String.format("Response status code was %s", response.getStatusCode()));
        }

        return ImmutableList.copyOf(response.getBody());
    }
}
