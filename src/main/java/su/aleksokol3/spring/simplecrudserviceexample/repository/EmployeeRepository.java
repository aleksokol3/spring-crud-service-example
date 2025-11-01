package su.aleksokol3.spring.simplecrudserviceexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.aleksokol3.spring.simplecrudserviceexample.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
