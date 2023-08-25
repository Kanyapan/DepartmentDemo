package com.example.oganizeationtree.repository;

import com.example.oganizeationtree.entity.Department;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department findByDepartmentId(@Param("DepartmentName") String name);

}