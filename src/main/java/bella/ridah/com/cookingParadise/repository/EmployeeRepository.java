package bella.ridah.com.cookingParadise.repository;

import bella.ridah.com.cookingParadise.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}