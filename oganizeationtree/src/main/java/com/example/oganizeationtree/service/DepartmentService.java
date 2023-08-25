package com.example.oganizeationtree.service;

import com.example.oganizeationtree.entity.Department;
import com.example.oganizeationtree.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;


    public List<Department> findAll() {
        return repository.findAll();
    }


    public Department findByDepartmentId(String id) {
        return repository.findByDepartmentId(id);

    }
}

