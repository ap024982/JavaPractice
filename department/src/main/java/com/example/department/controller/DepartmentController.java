package com.example.department.controller;

import com.example.department.model.deptModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.department.service.DepartmentService;
import com.example.department.model.deptModel;

import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService ds;

    @GetMapping("/{deptId}")
    public ResponseEntity<deptModel> getDepartmentById(@PathVariable Integer deptId) {
        Optional<deptModel> dept = ds.searchDepartment(deptId);
        return dept.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<deptModel> saveDepartment(@RequestBody deptModel r) {
        System.out.println("In post method");
        deptModel r1=ds.addDepartment(r);
        return ResponseEntity.ok(r1);
    }

}
