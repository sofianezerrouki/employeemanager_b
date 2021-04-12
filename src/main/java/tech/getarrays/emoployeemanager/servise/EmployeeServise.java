package tech.getarrays.emoployeemanager.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import tech.getarrays.emoployeemanager.model.Employee;
import tech.getarrays.emoployeemanager.repo.EmployeeRepo;
import tech.getarrays.emoployeemanagerexception.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServise {
    @Autowired
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServise(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepo.save(employee);
    }
    public Employee findEmployeeById(long id ){
    	
    	return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("Employee with id "+id+" not found :( "));
		 
    }
    public void deleteEmployeeById(long id){
    	 employeeRepo.deleteEmployeeById(id);
    }
    
    public List<Employee> findAllEmployee() {
    	return employeeRepo.findAll();
    }
    
    public Employee updateEmployee(Employee employee){
    	return employeeRepo.save(employee);
    }
    

}
