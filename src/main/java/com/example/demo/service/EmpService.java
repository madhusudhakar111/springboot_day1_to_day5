package com.example.demo.service;

import com.example.demo.dto.Employee;

import java.util.List;

public interface EmpService {

    public List<Employee> getEmp();

    void saveEmp(String eid, String ename, String ephoneNumber);


    void partialUpdateEmp(String eid, String ephoneNumber);

    void replaceEmp(String eid, Employee emp);

    void deleteEmployee(String id);
}
