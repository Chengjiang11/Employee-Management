package net.javaguides.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.ex.model.Employee;
import net.javaguides.ex.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployee());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String ShowNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		return "new_employee";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(Model model, @PathVariable("id") Long id){
		
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "update_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String delete(Model model,@PathVariable("id") Long id) {
		employeeService.delete(id);
		return "redirect:/";
	}
	
}
