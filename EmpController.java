package org.example.em_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ Corrected: Removed `/{id}`, as ID is auto-generated
    @PostMapping("/")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // ✅ Corrected: Changed `readEmployees(id)` to `readEmployee(id)`
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }

    // ✅ Corrected: Added `@GetMapping` to fetch all employees
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }

    // ✅ Corrected: Renamed method from `putMethodName` to `updateEmployee`
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
