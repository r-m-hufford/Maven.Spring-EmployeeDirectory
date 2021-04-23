package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Employee> employeeList = new ArrayList<>();
        repository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public Employee readOne(Long id) {
        return repository.findOne(id);
    }

    public Employee update(Employee e, Long id) {
        Employee employee = readOne(id);
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

    public List<Employee> findHierarchy(Long id) {
        List<Employee> hierarchy = new ArrayList<>();

        Employee employee;
        Long currentId = 0L;

        while (currentId != null) {
            currentId = 0L;
            employee = repository.findOne(id);
            currentId = employee.getId();
            hierarchy.add(employee);
        }


        return null;
    }

    public void delete(Long id) {
        repository.delete(repository.findOne(id));
    }

    public Employee updateManager(Employee e, Long id) {
        Employee employee = readOne(id);
        employee.setManagerId(e.getManagerId());
        return repository.save(employee);
    }

    public List<Employee> findByManager(Long id) {
        List<Employee> findByManager = new ArrayList<>();
        for (Employee employee : repository.findAll()) {
            if (employee.getManagerId() == id) {
                findByManager.add(employee);
            }
        }
        return findByManager;
    }

    public List<Employee> findWithNoManager() {
        List<Employee> findNoManager = new ArrayList<>();
        for (Employee employee : repository.findAll()) {
            if (employee.getManagerId() == null) {
                findNoManager.add(employee);
            }
        }
        return findNoManager;
    }

    public List<Employee> findByDeptId(Long id) {
        List<Employee> findByDeptId = new ArrayList<>();
        for (Employee employee : repository.findAll()) {
            if (employee.getDeptNum() == id) {
                findByDeptId.add(employee);
            }
        }
        return findByDeptId;
    }
}
