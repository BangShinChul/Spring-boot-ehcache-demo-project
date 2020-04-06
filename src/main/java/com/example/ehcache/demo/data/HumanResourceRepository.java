package com.example.ehcache.demo.data;

import com.example.ehcache.demo.model.HumanResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanResourceRepository extends JpaRepository<HumanResource, Long> {
    public List<HumanResource> findByDepartment(HumanResource.Department department);
    public List<HumanResource> findByDepartmentAndName(HumanResource.Department department, String name);

}
