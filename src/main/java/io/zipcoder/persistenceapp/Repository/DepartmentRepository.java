package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
