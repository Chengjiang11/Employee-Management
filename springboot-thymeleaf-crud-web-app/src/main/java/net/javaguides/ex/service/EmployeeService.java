package net.javaguides.ex.service;

import java.util.List;

import net.javaguides.ex.model.Employee;

public interface EmployeeService {
    List<Employee>getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void delete(long id);
}
