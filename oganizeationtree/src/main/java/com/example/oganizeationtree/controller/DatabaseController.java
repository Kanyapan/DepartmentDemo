package com.example.oganizeationtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DatabaseController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test-connection")
    public String testConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Database connection is working!";
        } catch (Exception e) {
            return "Database connection is not working: " + e.getMessage();
        }
    }
}
