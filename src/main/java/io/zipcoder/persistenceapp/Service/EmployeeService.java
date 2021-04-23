package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public Employee createEmployee(Employee e) {
        return repository.save(e);
    }

    public List<Employee> readAll() {
        return repository.findAll();
    }

    public Employee readOne(Long id) {
        return repository.findOne(id);
    }

    public Employee update(Employee e, Long id) {
        Employee employee = readOne(id);
        employee.setEmployeeNumber(e.getEmployeeNumber());
        employee.setEmail(e.getEmail());
        employee.setDeptNum(e.getDeptNum());
        employee.setFirstName(e.getFirstName());
        employee.setLastName(e.getLastName());
        employee.setTitle(e.getTitle());
        employee.setPhoneNumber(e.getPhoneNumber());
        employee.setHireDate(e.getHireDate());
        employee.setManagerId(e.getManagerId());

        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.delete(repository.findOne(id));
    }
}
