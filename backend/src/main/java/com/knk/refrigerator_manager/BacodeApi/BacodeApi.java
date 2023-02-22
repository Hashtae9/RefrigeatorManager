package com.knk.refrigerator_manager.BacodeApi;

import com.knk.refrigerator_manager.BacodeApi.BacodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class BacodeApi {
    private final WebClient webClient;
    private final String key = "76e93aeb4c5b4f389df2"; ///76e93aeb4c5b4f389df2/C005/json/1/5/BAR_CD={b}"
    private final String url = "http://openapi.foodsafetykorea.go.kr/api";

    public BacodeApi(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public String requestBacode(String b){
        return this.webClient.get().uri("/" + key + "/C005/json/1/1/BAR_CD=" + b)
                .retrieve().bodyToMono(String.class).block();
        //.bodyToMono(BacodeDTO.class).block();
    }
}
