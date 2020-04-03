package com.example.ehcache.demo.controller;


import com.example.ehcache.demo.utils.EhcacheManagerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/clear")
public class CacheClearController {

    @Autowired
    EhcacheManagerUtil util;

    @RequestMapping(value = "/cache/{cache_name}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> clearCacheByName(@PathVariable(name = "cache_name") String cacheName) {
        util.clearCache(cacheName);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/cache/all", method = RequestMethod.DELETE)
    public ResponseEntity<Void> clearCacheAll() {
        util.clearCacheAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
