package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Department;
import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Repository.DepartmentRepository;
import io.zipcoder.persistenceapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService(DepartmentRepository repository, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    public Department createDepartment(Department d) {
        return repository.save(d);
    }

    public List<Department> readAll() {
        return repository.findAll();
    }

    public Department readOne(Long id) {
        return repository.findOne(id);
    }

    public Department updateDepartment(Department d, Long id) {
        Department department = readOne(id);
        department.setDeptName(d.getDeptName());
        department.setManagerId(d.getManagerId());

        return repository.save(department);
    }

    public void deleteDepartment(Long id) {
        repository.delete(repository.findOne(id));
    }

    public Department updateManager(Department d, Long id) {
        Department department = readOne(id);
        department.setManagerId(d.getManagerId());

        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getDeptNum() == department.getId()) {
                employee.setManagerId(department.getManagerId());
                employeeRepository.save(employee);
            }
        }
        return repository.save(department);
    }

    public Department updateDeptName(Department d, Long id) {
         Department department = readOne(id);
         department.setDeptName(d.getDeptName());
         return repository.save(department);
    }
}
