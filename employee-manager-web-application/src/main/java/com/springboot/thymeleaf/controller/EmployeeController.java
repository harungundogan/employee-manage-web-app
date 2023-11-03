package com.springboot.thymeleaf.controller;

import com.springboot.thymeleaf.entity.Employee;
import com.springboot.thymeleaf.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeServiceImpl employeeService;

	public EmployeeController(EmployeeServiceImpl theEmployeeService) {
		employeeService = theEmployeeService;
	}


	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);

		return "employee-form";
	}

	@PostMapping("/save")

	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()){
			return "employee-form";
		}
		else{
			employeeService.save(theEmployee);
			return "redirect:/employees/list";

		}

	}

	@GetMapping("/delete")

	public String deleteEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}
}









