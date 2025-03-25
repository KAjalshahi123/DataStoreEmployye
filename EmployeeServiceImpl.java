package org.example.em_project;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        Optional<EmployeeEntity> optionalEmp = employeeRepository.findById(id);

        if (optionalEmp.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmp.get();
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }
        return null; // Or throw an exception
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            BeanUtils.copyProperties(employeeEntity, emp);
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        Optional<EmployeeEntity> optionalEmp = employeeRepository.findById(id);

        if (optionalEmp.isPresent()) {
            EmployeeEntity existingEmployee = optionalEmp.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());

            employeeRepository.save(existingEmployee);
            return "Updated Successfully";
        }
        return "Employee Not Found";
    }
}
