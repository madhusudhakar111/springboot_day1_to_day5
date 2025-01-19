package com.example.demo.dao;

import com.example.demo.dto.Employee;

import java.util.List;

public interface EmpDao {
    List<Employee> getEmp();

    int saveEmp(Employee emp);


}
