package com.example.ehcache.demo.service;

import com.example.ehcache.demo.data.HrTxManager;
import com.example.ehcache.demo.model.HumanResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HrService {

    @Autowired
    HrTxManager hrTxManager;

    public Map<String, List<HumanResource>> getHrByDepartment() {
        return hrTxManager.getHrByDepartment();
    }

    public List<HumanResource> getHrList() {
        return hrTxManager.getHrList();
    }

    public List<HumanResource> getHrListByDepartment(String department) {
        return hrTxManager.getHrListByDepartment(department);
    }
}
