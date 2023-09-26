package com.example.oganizationtree.service;

import com.example.oganizationtree.entity.Department;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface DepartmentInterface {

    List<Department> findAll();

    Department findByDepartmentName(String id);

    Workbook generateExcel(List<Department> dataList);
}
