package com.example.department.repository;

import com.example.department.model.deptModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<deptModel,Integer> {
}
