package springbootapp.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServices {

	@Autowired
	private EmployeesRepository employeeRepository;

	/*
	 * private List<Employee> employees = new ArrayList<Employee>(Arrays.asList( new
	 * Employee("101", "Raj", "Testing"), new Employee("102", "Richard", "Testing"),
	 * new Employee("103", "Aryan", "Testing") ));
	 */

	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;


	}

	public Optional<Employee> getEmployee(String empId){
		return employeeRepository.findById(empId);

	}

	public void addEmployee(Employee employee){
		employeeRepository.save(employee);
	}

	public void updateEmployee(String empId, Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(String empId){
		employeeRepository.deleteById(empId);
	}



}
