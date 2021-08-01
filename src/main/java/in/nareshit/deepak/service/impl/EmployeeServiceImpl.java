package in.nareshit.deepak.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.nareshit.deepak.Model.Employee;
import in.nareshit.deepak.exception.EmployeeNotFoundException;
import in.nareshit.deepak.repo.EmployeeRepository;
import in.nareshit.deepak.service.IEmployeeService;
import in.nareshit.deepak.util.EmployeeUtil;

@Component
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private EmployeeUtil util;

	public Integer saveEmployee(Employee e) {
		util.calculateData(e);
		e = repo.save(e);
		return e.getEmpId();
	}

	public void updateEmployee(Employee e) {

		if (e.getEmpId() != null && repo.existsById(e.getEmpId())) {
			util.calculateData(e);
			repo.save(e);
		} else {
			throw new EmployeeNotFoundException("Employee " + e.getEmpId() + " not exist");
		}

	}

	public void deleteEmployee(Integer id) {

		repo.delete(getOneEmployee(id));

	}

	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			throw new EmployeeNotFoundException("Employee " + id + " not exist");

	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
