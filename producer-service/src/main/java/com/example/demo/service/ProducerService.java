package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerService {

    @Autowired
    private RestTemplate restTemplate;

    public String makeRequestsToClient() {

        return null;
    }




}
