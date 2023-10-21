package com.api.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.userdept.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  
}
