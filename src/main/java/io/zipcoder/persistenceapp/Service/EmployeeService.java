package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public void delete(Long id) {
        repository.delete(repository.findOne(id));
    }

    public Employee updateManager(Employee e, Long id) {
        Employee employee = readOne(id);
        employee.setManagerId(e.getId());
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

    //   everyone/thing upstream
    public List<Employee> findHierarchy(Long id) {
        List<Employee> hierarchy = new ArrayList<>();

        Employee currentEmployee = repository.findOne(id);

        while (currentEmployee.getManagerId() != null) {
            hierarchy.add(repository.findOne(currentEmployee.getManagerId()));
            currentEmployee = repository.findOne(currentEmployee.getManagerId());
        }
        return hierarchy;
    }

    //   everyone/thing downstream
    /*public List<Employee> findDownstream(@PathVariable Long id) {
        List<Employee> downStream = new ArrayList<>();
        Employee manager = repository.findOne(id);

        for (Employee employee : repository.findAll()) {
            if(employee.getManagerId() == manager.getId()) {
                downStream.add(employee);
            }
        }
        // int start = 0
        // start = downstream.size - inside first loop
        // i = start
        //
        for (int i = 0; i < downStream.size();i++) {
            for (Employee employee : repository.findAll()) {
                if (employee.getManagerId() == downStream.get(i).getId()) {
                    downStream.add(employee);
                }
            }
        }
        return downStream;
    }*/




}
