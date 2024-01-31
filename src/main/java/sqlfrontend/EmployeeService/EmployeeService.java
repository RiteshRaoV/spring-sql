package sqlfrontend.EmployeeService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sqlfrontend.Employee.Employee;
import sqlfrontend.EmployeeRepository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
    public void saveEmployee(Employee employee){
        repo.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long id){
        return repo.findById(id);
    }
    public void updateEmployee(Employee employee){
        repo.save(employee);
    }
    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}
