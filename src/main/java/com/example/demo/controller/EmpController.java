package com.example.demo.controller;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/getemp")
    public List<Employee> getemp() {
        return empService.getEmp();
    }

    @PostMapping("/saveemp")
    public String saveEmpName(@RequestParam String eid, @RequestParam String ename, @RequestParam String ephoneNumber) {
    String response;
        try {
            empService.saveEmp(eid, ename, ephoneNumber);
            response = "succes";
        } catch (Exception e) {
            e.printStackTrace();
            response = "failed";
        }
        return response;
    }


    @PatchMapping("/partialupdateemp")
    public String partialUpdateEmp(@RequestParam String eid,  @RequestParam String phoneNumber) {
        String response;
        try {
            empService.partialUpdateEmp(eid,  phoneNumber);
            response = "succes";
        } catch (Exception e) {
            e.printStackTrace();
            response = "failed";
        }
        return response;
    }

    @PutMapping("/updateemp")
    public String updateEmp(@RequestParam String eid, @RequestBody Employee emp) {
        String response;
        try {
            empService.replaceEmp(eid, emp);
            response = "succes";
        } catch (Exception e) {
            e.printStackTrace();
            response = "failed";
        }
        return response;
    }

    @DeleteMapping("delete/{eid}")
    public String deleteEmp(@PathVariable String eid) {
        String response;
        try {
            empService.deleteEmployee(eid);
            response = "succes";
        } catch (Exception e) {
            e.printStackTrace();
            response = "failed";
        }
        return response;
    }

}
