package tech.getarrays.emoployeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.emoployeemanager.model.Employee;
import tech.getarrays.emoployeemanager.servise.EmployeeServise;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {
	@Autowired
	public final EmployeeServise employeeServise;
	
	public EmployeeController(EmployeeServise employeeServise) {
		this.employeeServise= employeeServise;
	}
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeServise.findAllEmployee();
				
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id ) {
		return employeeServise.findEmployeeById(id);
	}
	@PostMapping
	public ResponseEntity <Employee>addEmployee(@RequestBody Employee theEmployee)	{
		Employee employee = employeeServise.addEmployee(theEmployee) ;
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}
	@PutMapping
	public ResponseEntity <Employee>updateEmployee(@RequestBody Employee theEmployee)	{
		Employee employee = employeeServise.addEmployee(theEmployee) ;
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/{theId}")
	public ResponseEntity<?> addEmployee(@PathVariable long theId)	{
		
		employeeServise.deleteEmployeeById(theId) ;
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}
