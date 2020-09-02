package com.example.baseconcept.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CallApiUtil {

    public static ResponseEntity callApi(String url, Map<String, String> params, HttpMethod httpMethod, Object body) {

        HttpHeaders httpHeaders = new HttpHeaders();

        HttpEntity request = null;
        if (httpMethod == HttpMethod.GET) {
            request = new HttpEntity(httpHeaders);
        } else if (httpMethod == HttpMethod.POST) {
            request = new HttpEntity(body, httpHeaders);
        }
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriBuilder.queryParam(entry.getKey(), entry.getValue());
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return restTemplate.exchange(
                uriBuilder.toUriString(),
                httpMethod,
                request,
                String.class
        );

    }
}
