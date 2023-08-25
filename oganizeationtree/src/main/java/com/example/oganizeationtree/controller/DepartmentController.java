package com.example.oganizeationtree.controller;

import com.example.oganizeationtree.entity.Department;
import com.example.oganizeationtree.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentservice;


    @GetMapping("/departments")
    public ResponseEntity<List<Department>> findAll() {
        List<Department> list= departmentservice.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/departmentName")
    public ResponseEntity<Department> findById(@RequestParam String id) {
        Department department= departmentservice.findByDepartmentId(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
