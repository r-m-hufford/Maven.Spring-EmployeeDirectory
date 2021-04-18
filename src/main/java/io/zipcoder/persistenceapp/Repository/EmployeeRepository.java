package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
