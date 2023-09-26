package com.example.oganizationtree.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String departmentId;

    private String departmentName;
    private String orgCode;

// Other fields, getters, setters...
}
