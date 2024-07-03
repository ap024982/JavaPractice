package com.example.department.service;

import com.example.department.model.deptModel;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService  {

    @Autowired
    private DepartmentRepository dRepository;

    public Optional<deptModel> searchDepartment(Integer id){
        return dRepository.findById(id);
    }

    public deptModel addDepartment(deptModel d){
        return dRepository.save(d);
    }
}
