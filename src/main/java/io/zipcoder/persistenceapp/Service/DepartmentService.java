package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Department;
import io.zipcoder.persistenceapp.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
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
        department.setManager(d.getManager());

        return repository.save(department);
    }

    public void deleteDepartment(Long id) {
        repository.delete(repository.findOne(id));
    }

}
