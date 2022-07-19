package net.javaguides.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.ex.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
