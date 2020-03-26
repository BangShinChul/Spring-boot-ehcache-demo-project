package com.example.ehcache.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class NumberService {

    @Cacheable(value = "squareCache", key = "#number", condition = "#number > 10")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
        log.info("square of {} is {}", number, square);
        return square;
    }

}
