package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Employee;
import io.zipcoder.persistenceapp.Service.EmployeeService;
import org.apache.coyote.Response;
import org.hibernate.annotations.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
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

    @PutMapping("/employee/update_manager/{id}")
    ResponseEntity<Employee> updateManger(@RequestBody Employee e, @PathVariable Long id) {
        Employee employee = service.updateManager(e, id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee/findByManager/{id}")
    ResponseEntity<List<Employee>> employeesByManager(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByManager(id));
    }

    @GetMapping("/employee/findNoManager")
    ResponseEntity<List<Employee>> employeesWithNoManager() {
        return ResponseEntity.ok(service.findWithNoManager());
    }

    @GetMapping("/employee/findByDeptId/{id}")
    ResponseEntity<List<Employee>> findByDeptId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByDeptId(id));
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Employee " + id + " has been removed.");
    }

    @GetMapping("/employee/findHierarchy/{id}")
    ResponseEntity<List<Employee>> findHierarchy(@PathVariable Long id) {
        return ResponseEntity.ok(service.findHierarchy(id));
    }

    @GetMapping("/employee/downstream/{id}")
    ResponseEntity<List<Employee>> findDownstream(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDownstream(id));
    }

    @DeleteMapping("/employee/removeEmployees")
    public ResponseEntity<String> removeEmployees(List<Employee> employees) {
        service.removeEmployees(employees);
        return ResponseEntity.ok("Listed employees have been removed");
    }

    @DeleteMapping("/employee/removeByDepartment/{id}")
    public ResponseEntity<String> removeByDepartment(@PathVariable Long id) {
            service.removeByDepartment(id);
            return ResponseEntity.ok("All employees in dept. " + id + " have been removed");
        }

    @DeleteMapping("/employee/deleteDownstream/{id}")
    public ResponseEntity<String> removeDownstream(@PathVariable Long id) {
        service.deleteDownstream(id);
        return ResponseEntity.ok("All employees that report directly or indirectly to employee num. "
                + id + " have been removed");
    }

    @PutMapping("/employee/replaceAndAbsorb/{id}")
    public ResponseEntity<List<Employee>> replaceAndAbsorb(@PathVariable Long id) {
        List<Employee> newTeam = service.removeAndAbsorb(id);
        return ResponseEntity.ok(newTeam);
    }

    @GetMapping("/employee/details/{id}")
    public ResponseEntity<String> employeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.employeeDetails(id));
    }
}
