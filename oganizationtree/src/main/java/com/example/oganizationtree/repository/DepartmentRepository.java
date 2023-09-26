package com.example.oganizationtree.repository;

import com.example.oganizationtree.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department findByDepartmentId(@Param("DepartmentName") String name);

}