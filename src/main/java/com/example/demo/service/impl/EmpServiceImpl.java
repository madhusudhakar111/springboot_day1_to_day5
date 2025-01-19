package com.example.demo.service.impl;

import com.example.demo.dao.EmpDao;
import com.example.demo.dto.Employee;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Employee> getEmp() {
        return empDao.getEmp();
    }

   @Override
   public void saveEmp(String eid, String ename, String ephoneNumber){

       Employee empObj = new Employee();
       empObj.setId(eid);
       empObj.setName(ename);
       empObj.setPhoneNumber(ephoneNumber);

       empDao.saveEmp(empObj);

    }


    @Override
    public void partialUpdateEmp(String eid, String ephoneNumber) {
        Employee empObj = new Employee();
        empObj.setId(eid);
        empObj.setPhoneNumber(ephoneNumber);
        empDao.partialUpdateEmp(empObj);

    }

    @Override
    public void replaceEmp(String eid, Employee empObj) {

        empDao.replaceEmp(eid, empObj);
    }

    @Override
    public void deleteEmployee(String id) {
        empDao.deleteEmployee(id);
    }




}
