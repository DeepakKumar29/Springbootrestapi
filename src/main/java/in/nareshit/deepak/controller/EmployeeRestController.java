package in.nareshit.deepak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.nareshit.deepak.exception.EmployeeNotFoundException;
import in.nareshit.deepak.Model.Employee;
import in.nareshit.deepak.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;

//1. Get All employees
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

//2. Get one Employee
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		try {
			Employee employee = service.getOneEmployee(id);
			response = new ResponseEntity<Employee>(employee, HttpStatus.OK); // 200
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		}
		return response;
	}

//3. create one Employee
	@PostMapping("/save")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		Integer id = service.saveEmployee(employee);
		String message = "Employee '" + id + "' Created!";
		return new ResponseEntity<String>(message, HttpStatus.CREATED); // 201
	}

//4. delete record by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		ResponseEntity<String> response = null;
		try {
			service.deleteEmployee(id);
			String message = "Employee '" + id + "' Deleted!";
			response = new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			throw e;
		}
		return response;
	}

//5. update record
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> response = null;
		try {
			service.updateEmployee(employee);
			String message = "Employee updated!";
			response = new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			throw e;
		}
		return response;
	}
}