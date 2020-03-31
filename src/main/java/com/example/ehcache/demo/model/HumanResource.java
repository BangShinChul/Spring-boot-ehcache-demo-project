package com.example.ehcache.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "human_resource")
public class HumanResource {
    public enum Department {
        Dev, Marketing, Sales, Manage
    }

    public enum Rank {
        Worker, Manager, DepartmentHead
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "insert_time", insertable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    protected Date insertTime;

    @Column(name = "update_time", insertable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    protected Date updateTime;

    @Column(name = "delete_time")
    @JsonIgnore
    protected Date deleteTime;

    /***/

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Department department; // 부서

    @Column(name = "rank")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Rank rank; // 직급

    @Column(name = "name")
    @NotNull
    private String name; // 이름

    @Column(name = "salary")
    @NotNull
    private BigInteger salary; // 연봉

    public Department getStringDepartment(String insertDepartment) {
        switch (insertDepartment.toLowerCase()) {
            case "dev" :
                return Department.Dev;
            case "marketing" :
                return Department.Marketing;
            case "sales" :
                return Department.Sales;
            case "manage" :
                return Department.Manage;
            default:
                return null;
        }
    }

}
