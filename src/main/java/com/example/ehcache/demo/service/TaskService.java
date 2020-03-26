package com.example.ehcache.demo.service;

import com.example.ehcache.demo.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskService {

    @Cacheable("taskCache")
    public List<Task> findAll() {
        log.info("Retrieving tasks");
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "My First task", true));
        tasks.add(new Task(2L, "My Second task", false));
        return tasks;
    }


    @Cacheable(value = "taskByUserIdCache", key = "#userId")
    public List<Task> findAllByUserId(Integer userId) {
        log.info("Retrieving tasks By UserId");
        List<Task> tasks = new ArrayList<>();

        switch (userId) {
            case 1:
                tasks.add(new Task(1L, "1's First task", true));
                tasks.add(new Task(2L, "1's Second task", false));
                break;
            case 2:
                tasks.add(new Task(4L, "2's First task", true));
                break;
            case 3:
                tasks.add(new Task(3L, "3's First task", true));
                tasks.add(new Task(5L, "3's Second task", true));
                tasks.add(new Task(6L, "3's Third task", false));
                break;
            default:
                break;
        }

        return tasks;
    }
}
