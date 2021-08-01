package in.nareshit.deepak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.deepak.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
