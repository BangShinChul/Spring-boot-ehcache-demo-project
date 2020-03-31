package com.example.ehcache.demo.controller;

import com.example.ehcache.demo.model.HumanResource;
import com.example.ehcache.demo.service.HrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @GetMapping(path = "/map")
    public ResponseEntity<Map<String, List<HumanResource>>> getHrByDepartment() {
        log.info("call api getHrByDepartment");
        return new ResponseEntity<Map<String, List<HumanResource>>>(hrService.getHrByDepartment(), HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<HumanResource>> getHrList() {
        log.info("call api getHrList");
        return new ResponseEntity<List<HumanResource>>(hrService.getHrList(), HttpStatus.OK);
    }

    @GetMapping(path = "/list/{department}")
    public ResponseEntity<List<HumanResource>> getHrByDepartment(@PathVariable String department) {
        log.info("call api getHrByDepartment");
        return new ResponseEntity<List<HumanResource>>(hrService.getHrListByDepartment(department), HttpStatus.OK);
    }
}
