package com.EmployeeProject.EmployeeDataStore.Controller;



import com.EmployeeProject.EmployeeDataStore.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.EmployeeProject.EmployeeDataStore.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("employees")
public class EmpController {
    // EmployeeService employeeService = new EmployeeSerivceImp();
    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public String createEmployee(@RequestBody org.example.em_project.Model.Employee employee) {
        employeeService.createEmployee(employee);
        return "Save Succesfully";
    }

    @GetMapping("/{id}")
    public org.example.em_project.Model.Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }


}


