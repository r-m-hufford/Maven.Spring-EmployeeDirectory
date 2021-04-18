package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //create, read all, read one, update, delete;

    @PostMapping("/employee")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
        Employee employee = service.createEmployee(e);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee")
    ResponseEntity<List<Employee>> readAll() {
        List<Employee> employees = service.readAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<Employee> readOne(@PathVariable Long id) {
        Employee employee = service.readOne(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> update(@RequestBody Employee e, @PathVariable Long id) {
        Employee employee = service.update(e, id);
        return ResponseEntity.ok(employee);
    }
}
