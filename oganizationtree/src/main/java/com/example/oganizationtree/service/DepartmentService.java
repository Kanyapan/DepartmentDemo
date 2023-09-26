package com.example.oganizationtree.service;

import com.example.oganizationtree.entity.Department;
import com.example.oganizationtree.repository.DepartmentRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentInterface {
    @Autowired
    private DepartmentRepository repository;


    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Department findByDepartmentName(String id) {
        return null;
    }


    public Department findByDepartmentId(String id) {
        return repository.findByDepartmentId(id);
    }

    public Workbook generateExcel(List<Department> dataList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        List<Department> departmentList = repository.findAll();
        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("department_id");
        headerRow.createCell(1).setCellValue("department_name");
        headerRow.createCell(2).setCellValue("org_code");
        // Add more headers as needed

        // Populate the sheet with data
        int rowNum = 1;
        for (Department department : departmentList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(department.getDepartmentId());
            row.createCell(1).setCellValue(department.getDepartmentName());
            row.createCell(2).setCellValue(department.getOrgCode());
            // Add more cell values as needed
        }

        return workbook;
    }

}

