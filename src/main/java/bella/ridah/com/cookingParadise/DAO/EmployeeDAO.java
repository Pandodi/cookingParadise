package bella.ridah.com.cookingParadise.DAO;

import bella.ridah.com.cookingParadise.model.Employee;
import bella.ridah.com.cookingParadise.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeDAO {
    private EmployeeRepository repository;

    public EmployeeDAO(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Employee> findAllEmployees() {
        return repository.findAll ();
    }

    public Optional<Employee> findEmployeeByID(Long id) {
        return repository.findById (id);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById (id);
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save (employee);
    }


}
