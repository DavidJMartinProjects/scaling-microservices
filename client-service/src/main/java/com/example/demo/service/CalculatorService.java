package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author david
 */
@Service
@Slf4j
public class CalculatorService {

    public static final int UPPER_LIMIT = 1_000_000;

    public String getCalculation() {
        double x = 0.0001d;
        for (int index = 0; index < UPPER_LIMIT; index++) {
            x = Math.sqrt(x);
        }
        log.info("calculation complete.");
        return String.valueOf(x);
    }

}
