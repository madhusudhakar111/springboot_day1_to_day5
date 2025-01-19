package com.example.demo.dao.impl;

import com.example.demo.dao.EmpDao;
import com.example.demo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmp() {
        String sql = "SELECT * FROM emp";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getString("id"));
                emp.setName(rs.getString("name"));
                emp.setPhoneNumber(rs.getString("phonenumber"));
                return emp;
            }
        });
    }


    @Override
    public int saveEmp(Employee emp) {
        String sql = "INSERT INTO emp (id, name, phonenumber) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getPhoneNumber());
    }


    @Override
    public int partialUpdateEmp(Employee emp) {
        String sql = "UPDATE emp SET phonenumber = ? WHERE id = ?";
        return jdbcTemplate.update(sql, emp.getPhoneNumber(), emp.getId());
    }

    @Override
    public int replaceEmp(String eid, Employee emp) {
        String sql = "UPDATE emp SET id=?, name=?, phonenumber = ? WHERE id = ?";
        return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getPhoneNumber(), eid);
    }

    @Override
    public int deleteEmployee(String id) {
        String sql = "DELETE FROM emp WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }



}
