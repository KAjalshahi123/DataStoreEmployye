package com.EmployeeProject.EmployeeDataStore.Service;



import java.util.List;

public interface EmployeeService {

    String createEmployee(org.example.em_project.Model.Employee employee);
    List<org.example.em_project.Model.Employee> readEmployees();

    boolean deleteEmployee(Long id);
    org.example.em_project.Model.Employee readEmployee(Long id);

    String updateEmployee(Long id, org.example.em_project.Model.Employee employee);
}
