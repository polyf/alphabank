package com.alpha.bank.service;

import com.alpha.bank.model.CityDTO;
import com.alpha.bank.model.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BrazilApiService {

    private static final String BRAZIL_API_URL = "https://brazilapi.now.sh/api";

    private final RestTemplate restTemplate;

    @Autowired
    public BrazilApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StateDTO[] getStates() {
        return restTemplate.getForObject(BRAZIL_API_URL + "/dataloader/estados", StateDTO[].class);
    }

    public CityDTO[] getCitiesByState(String stateId) {
        return restTemplate.getForObject(BRAZIL_API_URL + "/dataloader/cidades/" + stateId, CityDTO[].class);
    }
}