package com.EmployeeProject.EmployeeDataStore.Repositry;



//import org.example.em_project.Entity.EmployeeEntity;
import com.EmployeeProject.EmployeeDataStore.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long > {
    // custom method

}