package bella.ridah.com.cookingParadise.service;

import bella.ridah.com.cookingParadise.DAO.EmployeeDAO;
import bella.ridah.com.cookingParadise.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest extends MockitoExtension {

    static EmployeeService unitUnderTest;
    @Mock
    private static EmployeeDAO employeeDAO;

    @BeforeAll
    public static void init() {
        employeeDAO = Mockito.mock(EmployeeDAO.class);
        unitUnderTest = new EmployeeService(employeeDAO);
    }


    @Test
    void getAllEmployees() {

        Employee employees = new Employee ();
        employees.setId (3L);
        employees.setFirstName ("gris");
        employees.setLastName ("woff");
        employees.setEmailId ("jaha@gmail.com");

        Employee employeeTwo = new Employee ();
        employeeTwo.setId (4L);
        employeeTwo.setFirstName ("nummertvå");
        employeeTwo.setLastName ("nummertvåå");
        employeeTwo.setEmailId ("gris@grisen.com");

        List<Employee> employeesList = List.of (employees, employeeTwo);
        Mockito.when (employeeDAO.findAllEmployees ()).thenReturn (employeesList);

        List<Employee> allEmployees = unitUnderTest.getAllEmployees ();

        assertEquals (2, allEmployees.size ());

    }

    @Test
    @DisplayName ("Verify that findEmployeeByID() returns specific employee from database")
    void findEmployeeByID() {

        Employee employeeFromDataBase = new Employee ();
        employeeFromDataBase.setId (1L);
        employeeFromDataBase.setFirstName ("isabella");

        Mockito.when (employeeDAO.findEmployeeByID (1L)).thenReturn (Optional.of(employeeFromDataBase));

        //Testing
        Employee verifiedEmployee = unitUnderTest.findEmployeeByID (1L);

        //Verifying
        //Verify
        assertEquals(1, verifiedEmployee.getId ());
        assertEquals("isabella", verifiedEmployee.getFirstName ());
    }


    @Test
    @DisplayName ("Make sure that RemoveEmployee will call the right method")
    void removeEmployee() {

        unitUnderTest.removeEmployee (5L);
        Mockito.verify (employeeDAO, Mockito.times (1)).deleteEmployee (5L);

    }

    @Test
    @DisplayName ("Verify that Employee is saved")
    void addEmployee() {
        Employee newEmployee = new Employee ();
        newEmployee.setId (null);
        newEmployee.setLastName ("Shabani");

        Employee employeeFromDatabase = new Employee ();
        employeeFromDatabase.setId (4L);
        employeeFromDatabase.setLastName ("Shabani");

        Mockito.when (employeeDAO.saveEmployee (newEmployee)).thenReturn (employeeFromDatabase);

        Employee employee = unitUnderTest.addEmployee (newEmployee);

        assertEquals (4, employee.getId ());
        assertEquals ("Shabani", employee.getLastName ());

    }

}