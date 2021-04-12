package tech.getarrays.emoployeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.emoployeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	void deleteEmployeeById(long id);
	Optional<Employee> findEmployeeById(long id);
}
