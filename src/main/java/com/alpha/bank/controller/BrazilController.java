package com.alpha.bank.controller;

import com.alpha.bank.model.dto.CityDTO;
import com.alpha.bank.model.dto.StateDTO;
import com.alpha.bank.service.BrazilApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brazil")
public class BrazilController {

    private final BrazilApiService brazilApiService;

    @Autowired
    public BrazilController(BrazilApiService brazilApiService) {
        this.brazilApiService = brazilApiService;
    }

    @GetMapping("/states")
    public StateDTO[] getStates() {
        return brazilApiService.getStates();
    }

    @GetMapping("/cities/{stateId}")
    public CityDTO[] getCitiesByState(@PathVariable String stateId) {
        return brazilApiService.getCitiesByState(stateId);
    }
}