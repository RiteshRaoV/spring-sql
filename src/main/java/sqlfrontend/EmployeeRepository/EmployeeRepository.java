package sqlfrontend.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sqlfrontend.Employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
