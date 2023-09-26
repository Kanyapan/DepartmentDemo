package com.example.oganizeationtree.controller;

import com.example.oganizeationtree.entity.Department;
import com.example.oganizeationtree.service.DepartmentService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController

public class DepartmentController {

    @Autowired
    private DepartmentService departmentservice;


    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> findAll() {
        List<Department> list = departmentservice.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDepartmentName")
    public ResponseEntity<Department> findById(@RequestParam String id) {
        Department department = departmentservice.findByDepartmentId(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/generate")
    public ResponseEntity<ByteArrayResource> generateExcel() {
        List<Department> dataList = departmentservice.findAll(); // Replace with your data retrieval logic

        Workbook workbook = departmentservice.generateExcel(dataList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDispositionFormData("attachment", "data_export.xlsx");

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            ByteArrayResource resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

