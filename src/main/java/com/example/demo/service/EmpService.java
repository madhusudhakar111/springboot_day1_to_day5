package com.example.demo.service;

import com.example.demo.dto.Employee;

import java.util.List;

public interface EmpService {

    public List<Employee> getEmp();

    void saveEmp(String eid, String ename, String ephoneNumber);


}
