package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author david
 */
@RestController
@RequestMapping("/")
@Slf4j
public class ClientController {

    static final String CALCULATE_PATH = "/calculate";

    @Autowired
    CalculatorService calculatorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String greeting() {
        return "client-service online.";
    }

    @GetMapping(CALCULATE_PATH)
    @ResponseStatus(HttpStatus.OK)
    public String getCalculation() {
        log.info("GET request to {}.", CALCULATE_PATH);
        return calculatorService.getCalculation();

    }
}
