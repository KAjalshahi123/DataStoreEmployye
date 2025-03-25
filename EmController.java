package com.DataStore.SpringBootDataStore;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api")  // Base URL
public class EmController {

    private List<Employee> employees = new CopyOnWriteArrayList<>();

    @GetMapping("/employees")  // Use leading "/"
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Saved Successfully";
    }
}
