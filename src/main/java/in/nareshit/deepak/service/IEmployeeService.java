package in.nareshit.deepak.service;

import java.util.List;

import in.nareshit.deepak.Model.Employee;

public interface IEmployeeService {
	
	Integer saveEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	List<Employee> getAllEmployees();
	

}
