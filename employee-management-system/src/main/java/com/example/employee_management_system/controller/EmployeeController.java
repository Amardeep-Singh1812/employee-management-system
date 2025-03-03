package com.example.employee_management_system.controller;

import com.example.employee_management_system.model.Employee;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ReactiveOffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("register")
    public ResponseEntity<Employee> RegisterEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.createEmployee(employee);
        if(emp != null) {
            return ResponseEntity.status(201).body(emp);
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("list")
    public ResponseEntity<List<Employee>> listOfEmployees(){
        List<Employee> empList = employeeService.getAllEmployees();
        if(empList != null) {
            return ResponseEntity.status(201).body(empList);
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee emp = employeeService.getEmployeeById(id);
        if(emp != null) {
            return ResponseEntity.status(201).body(emp);
        }
        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(200).build();
    }

}
