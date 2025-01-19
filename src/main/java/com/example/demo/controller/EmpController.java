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
        // To-Do for paritical update      1, 900
        return "success";
    }

    @PutMapping("/updateemp")
    public String updateEnp(@RequestParam String eid, @RequestParam String ename, @RequestParam String phoneNumber) {
        // To-Do for update   2 ,  Ram , 3333
        return "success";
    }

    @DeleteMapping("{eid}")
    public String deleteEmp(@PathVariable String eid) {
        // To-Do for paritical delete      1, 900
        return "success";
    }


}
