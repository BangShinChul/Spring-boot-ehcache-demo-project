package com.example.ehcache.demo.controller;

import com.example.ehcache.demo.model.Task;
import com.example.ehcache.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(path = "/all")
    public List<Task> getAllTasks() {
        log.info("call taskService.findAll");
        return taskService.findAll();
    }

    @GetMapping(path = "/all/{userId}")
    public List<Task> getAllTasksByUserId(@PathVariable Integer userId) {
        log.info("call taskService.findAllByUserId");
        return taskService.findAllByUserId(userId);
    }
}
