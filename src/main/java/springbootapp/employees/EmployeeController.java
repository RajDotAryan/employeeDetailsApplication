package springbootapp.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmpServices empServices ;
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empServices.getAllEmployees();
	}
	
	@RequestMapping("/employees/{empId}")
	public Optional<Employee> getEmployee(@PathVariable String empId) {
		return empServices.getEmployee(empId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/employees/create")
	public void addEmployee(@RequestBody Employee employee) {
		empServices.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value= "/employees/update/{empId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String empId) {
		empServices.updateEmployee(empId, employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/employees/{empId}")
	public void deleteEmployee(@PathVariable String empId) {
		empServices.deleteEmployee(empId);
	}
}
