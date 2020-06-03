package com.karthik.spring.fcm.services;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.karthik.spring.fcm.model.FCMClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PushNotificationService
{

  @Async
  public CompletableFuture<String> send(HttpEntity<String> entity, FCMClient client) {

    RestTemplate restTemplate = new RestTemplate();

    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + client.getFirebaseServerKey()));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
    restTemplate.setInterceptors(interceptors);

    String firebaseResponse = restTemplate.postForObject(client.getFirebaseApiUrl(), entity, String.class);

    return CompletableFuture.completedFuture(firebaseResponse);
  }

}
