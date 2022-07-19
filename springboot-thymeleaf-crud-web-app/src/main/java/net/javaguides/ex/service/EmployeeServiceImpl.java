package net.javaguides.ex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.ex.model.Employee;
import net.javaguides.ex.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee>option= employeeRepository.findById(id);
		Employee employee= null;
		
		if(option.isPresent()) {
			employee = option.get();
		}else {
			throw new RuntimeException("Employee not found: "+id);
		}
		
		return employee;
	}

	@Override
	public void delete(long id) {
		employeeRepository.deleteById(id);
		
	}

}
