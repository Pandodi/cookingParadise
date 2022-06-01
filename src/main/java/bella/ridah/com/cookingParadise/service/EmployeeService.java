package bella.ridah.com.cookingParadise.service;

import bella.ridah.com.cookingParadise.DAO.EmployeeDAO;
import bella.ridah.com.cookingParadise.model.Employee;
import bella.ridah.com.cookingParadise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeDAO.findAllEmployees ();
    }

    public Employee findEmployeeByID(Long id) {
        return employeeDAO.findEmployeeByID (id).orElse (null);
    }

    public void removeEmployee(Long id) {
        employeeDAO.deleteEmployee (id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeDAO.saveEmployee (employee);
    }


}