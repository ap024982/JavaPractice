package com.example.department.model;

import jakarta.persistence.*;

@Entity
@Table(name="Department")
public class deptModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="deptId")
    private Integer deptId;

    @Column(name = "dName")
    private String dName;

    @Column(name = "location")
    private String strLocation;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getStrLocation() {
        return strLocation;
    }


    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }

    public deptModel(){
    }
}
