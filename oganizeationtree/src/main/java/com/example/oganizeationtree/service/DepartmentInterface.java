package com.example.oganizeationtree.service;

import com.example.oganizeationtree.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentInterface {
    List<Department> findAll();


    Department findByDepartmentName(String id);
}
