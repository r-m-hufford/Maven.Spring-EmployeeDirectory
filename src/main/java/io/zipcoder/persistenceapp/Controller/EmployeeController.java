package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/API")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

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

    @GetMapping("/employee/findByManager/{id}")
    ResponseEntity<List<Employee>> employeesByManager(@PathVariable Long id) {
        List<Employee> findByManager = new ArrayList<>();
        for (Employee employee : service.readAll()) {
            if (employee.getManagerId() == id) {
                findByManager.add(employee);
            }
        }
        return ResponseEntity.ok(findByManager);
    }

    @GetMapping("/employee/findNoManager/{id}")
    ResponseEntity<List<Employee>> employeesWithNoManager() {
        List<Employee> findNoManager = new ArrayList<>();
        for (Employee employee : service.readAll()) {
            if (employee.getManagerId() == null) {
                findNoManager.add(employee);
            }
        }
        return ResponseEntity.ok(findNoManager);
    }

    @GetMapping("/employee/findByDeptId/{id}")
    ResponseEntity<List<Employee>> findByDeptId(@PathVariable Long id) {
        List<Employee> findByDeptId = new ArrayList<>();
        for (Employee employee : service.readAll()) {
            if (employee.getDeptNum() == id) {
                findByDeptId.add(employee);
            }
        }
        return ResponseEntity.ok(findByDeptId);
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Employee " + id + " has been deleted.");
    }

    @GetMapping("?employee/findHierarchy")
    ResponseEntity<List<Employee>> findHierarchy(@PathVariable Long id) {
        List<Employee> hierarchy = new ArrayList<>();
        Employee employee = findByDeptId(id);

        return ResponseEntity.ok(hierarchy);
    }


}
