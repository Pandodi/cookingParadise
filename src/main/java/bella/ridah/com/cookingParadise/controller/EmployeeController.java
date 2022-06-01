package bella.ridah.com.cookingParadise.controller;


import bella.ridah.com.cookingParadise.model.Employee;
import bella.ridah.com.cookingParadise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @RequestMapping(value="/employees", method=RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return employeeService.getAllEmployees();
    }


    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void removeEmployee(@PathVariable(value = "empId") Long id) {
        employeeService.removeEmployee(id);
    }

}

