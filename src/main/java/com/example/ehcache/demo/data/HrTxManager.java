package com.example.ehcache.demo.data;

import com.example.ehcache.demo.model.HumanResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.ehcache.demo.model.HumanResource.*;

@Slf4j
@Service
public class HrTxManager {

    @Autowired
    HumanResourceRepository humanResourceRepository;

    @Cacheable(value = "hrByDepartmentCache")
    public Map<String, List<HumanResource>> getHrByDepartment() {
        log.info("]-----] hrTxManager getHrByDepartment [-----[");
        Map<String, List<HumanResource>> map = new HashMap<>();

        for (Department department : Department.values()) {
            map.put(department.toString(), humanResourceRepository.findByDepartment(department));
        }
        return map;
    }

    @Cacheable(value = "hrListCache")
    public List<HumanResource> getHrList() {
        log.info("]-----] hrTxManager getHrList [-----[");
        return humanResourceRepository.findAll();
    }

    @Cacheable(value = "hrListByDepartmentCache", key = "#department")
    public List<HumanResource> getHrListByDepartment(String department) {
        log.info("]-----] hrTxManager getHrListByDepartment [-----[");
        return humanResourceRepository.findByDepartment(new HumanResource().getStringDepartment(department));
    }
}
