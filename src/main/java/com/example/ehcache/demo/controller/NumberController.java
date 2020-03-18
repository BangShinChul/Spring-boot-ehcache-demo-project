package com.example.ehcache.demo.controller;


import com.example.ehcache.demo.service.NumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    NumberService numberService;

    @GetMapping(path = "/square/{number}")
    public String getSquare(@PathVariable Long number) {
        log.info("call numberService to square {}", number);
        return String.format("{\"square\": %s}", numberService.square(number));
    }
}
